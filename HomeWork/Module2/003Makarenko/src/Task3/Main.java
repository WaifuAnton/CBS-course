package Task3;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[]
                {
                        new Vehicle(2000, 5000, 200, 0, 0),
                        new Plane(1995, 100000, 750, 0, 0, 8, 12),
                        new Car(),
                        new Ship("Odessa")
                };
        for (Vehicle vehicle : vehicles)
            vehicle.showInfo();
    }
}
