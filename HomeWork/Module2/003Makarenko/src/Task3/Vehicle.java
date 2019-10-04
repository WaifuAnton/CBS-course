package Task3;

public class Vehicle {
    protected int x, y;
    protected int year;
    protected double speed;
    protected int price;

    public Vehicle()
    {
        year = 2010;
        speed = 200;
        price = 2000;
    }

    public Vehicle(int year, int price, double speed, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.year = year;
        this.price = price;
        this.speed = speed;
    }

    protected String coordinates()
    {
        return "(" + x + "; " + y + ")";
    }

    public void showInfo()
    {
        System.out.println("Unknown vehicle " + '\n' +
                "Year: " + year + '\n' +
                "Price: " + price + '\n' +
                "Speed: " + speed + '\n' +
                "Coordinates: " + coordinates() + '\n');
    }
}
