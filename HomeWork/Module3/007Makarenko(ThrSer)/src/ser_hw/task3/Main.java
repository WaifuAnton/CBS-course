package ser_hw.task3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Car peugeot = new Car();
        Car mercedes = new Car("Mercedes", 2000, 250, 100000);
        File file = new File("src\\ser_hw\\task3\\cars.bin");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(peugeot);
            out.writeObject(mercedes);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Car car1, car2;
            car1 = (Car) in.readObject();
            car2 = (Car) in.readObject();
            System.out.println(car1);
            System.out.println(car2);
            in.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Something went wrong");
            System.out.println(e.fillInStackTrace());
        }
    }
}
