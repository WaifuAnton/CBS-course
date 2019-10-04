package Task3;

public class Ship extends Vehicle {
    private int passengers;
    private String port;

    public Ship()
    {
        port = "Unknown port";
    }

    public Ship(String port)
    {
        this.port = port;
    }

    public Ship(int year, int price, double speed, int x, int y, int passengers, String port)
    {
        super(year, price, speed, x, y);
        this.passengers = passengers;
        this.port = port;
    }

    @Override
    public void showInfo() {
        System.out.println("Ship " + '\n' +
                "Year: " + year + '\n' +
                "Price: " + price + '\n' +
                "Speed: " + speed + '\n' +
                "Coordinates: " + coordinates() + '\n' +
                "Passengers: " + passengers + '\n' +
                "Port: " + port + '\n');
    }
}
