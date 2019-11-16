import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        for (int i = 0; i < 3; i++) {
            animals[i] = new Animal(i + 1);
        }

        animals[0].setName("bull");
        animals[0].setPredator(false);
        animals[0].setRegion("everywhere");
        animals[0].setWeight(500);

        animals[1].setName("crocodile");
        animals[1].setPredator(true);
        animals[1].setRegion("Africa");
        animals[1].setWeight(550);

        animals[2].setName("octopus");
        animals[2].setPredator(false);
        animals[2].setRegion("ocean");
        animals[2].setWeight(4);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        for (Animal animal : animals) {
            session.save(animal);
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
