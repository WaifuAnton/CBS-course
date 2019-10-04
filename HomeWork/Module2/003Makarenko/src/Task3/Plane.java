package Task3;

public class Plane extends Vehicle {
    private int z;
    private int passengers;

    public Plane(int year, int price, double speed, int x, int y, int z, int passengers)
    {
        super(year, price, speed, x, y);
        this.z = z;
        this.passengers = passengers;
    }

    @Override
    protected String coordinates() {
        return "(" + x + "; " + y + "; " + z + ")";
    }

    @Override
    public void showInfo() {
        System.out.println("Plane " + '\n' +
                "Year: " + year + '\n' +
                "Price: " + price + '\n' +
                "Speed: " + speed + '\n' +
                "Coordinates: " + coordinates() + '\n' +
                "Passengers: " + passengers + '\n');
    }
}
