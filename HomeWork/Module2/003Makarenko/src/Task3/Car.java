package Task3;

public class Car extends Vehicle {
    @Override
    public void showInfo() {
        System.out.println("Car " + '\n' +
                "Year: " + year + '\n' +
                "Price: " + price + '\n' +
                "Speed: " + speed + '\n' +
                "Coordinates: " + coordinates() + '\n');
    }
}
