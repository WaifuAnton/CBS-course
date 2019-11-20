import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        for (int i = 0; i < 3; i++) {
            animals[i] = new Animal(i + 1);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Species: ");
            String species = scanner.nextLine();
            System.out.println("Predator? ");
            boolean isPredator = scanner.nextInt() == 0;
            System.out.println("Region: ");
            String region = scanner.next();
            System.out.println("Weight: ");
            int weight = scanner.nextInt();
            animals[i].setSpecies(species);
           animals[i].setPredator(isPredator);
            animals[i].setRegion(region);
            animals[i].setWeight(weight);
        }

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
