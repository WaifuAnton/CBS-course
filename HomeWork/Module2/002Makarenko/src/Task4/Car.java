package Task4;

public class Car {
    private int year;
    private double speed;
    private int weight;
    private String color;

    public Car()
    {
        this(0, 0, 0, "Transparent");
    }

    public Car(int weight)
    {
        this();
        this.weight = weight;
        color = "White";
    }

    public Car(String color)
    {
        this(0, 0, color);
    }

    public Car(int weight, String color)
    {
        this(weight, 0, color);
        year = 0;
        speed = 0;
    }

    public Car(int weight, int year, String color)
    {
        this.weight = weight;
        this.color = color;
        this.year = year;
        speed = 0;
    }

    public Car(int weight, int year, double speed, String color)
    {
        this.weight = weight;
        this.color = color;
        this.year = year;
        this.speed = speed;
    }

    public void showInfo()
    {
        System.out.println("Weight: " + weight + '\n' +
                "Year: " + year + '\n' +
                "Color: " + color + '\n' +
                "Speed: " + speed + '\n');
    }
}
