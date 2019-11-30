package animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public AnimalRepository() {
        emf = Persistence.createEntityManagerFactory("mohr");
        em = emf.createEntityManager();
    }

    public Animal getById(long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        em.close();
        return animal;
    }

    public void update(Animal animal) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
    }

    public void update(long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Animal animal = em.find(Animal.class, id);
            em.merge(animal);
        }
        catch (IllegalArgumentException e) {
            System.out.println("No animal with this id");
        }
        finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public void remove(long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Animal animal = em.find(Animal.class, id);
            em.remove(animal);
        }
        catch (IllegalArgumentException e) {
            System.out.println("No animal with this id");
        }
        finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public List<Animal> getAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animal FROM Animal animal");
        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return animals;
    }
}
