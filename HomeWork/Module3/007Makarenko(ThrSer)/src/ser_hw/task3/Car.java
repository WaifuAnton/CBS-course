package ser_hw.task3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {
    private static final long serialVersionUID = 4L;
    private transient String model = "Peugeot";
    private double price = 4000;
    private double weight = 1500;
    private int speed = 170;
    public final static String carInfo = "Cars have 4 wheels... mostly";

    public Car() { }

    public Car(String model, double weight, int speed, double price) {
        this.model = model;
        this.price = price;
        this.speed = speed;
        this.weight = weight;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(model);
        out.writeDouble(weight);
        out.writeInt(speed);
        out.writeDouble(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println(carInfo);
        model = (String) in.readObject();
        weight = in.readDouble();
        speed = in.readInt();
        price = in.readDouble();
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        String str = model + ", weight - " + weight + ", speed - " + speed + ", price - " + price;
        return str;
    }
}
