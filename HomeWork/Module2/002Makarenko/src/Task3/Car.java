package Task3;

public class Car {
    private int year;
    private double speed;
    private int weight;
    private String color;

    public Car()
    {
        speed = 0;
        weight = 0;
        color = "transparent";
        year = 0;
    }

    public Car(int weight)
    {
        year = 0;
        speed = 0;
        this.weight = weight;
        color = "white";
    }

    public Car(String color)
    {
        speed = 0;
        weight = 0;
        this.color = color;
        year = 0;
    }

    public Car(int weight, String color)
    {
        this.weight = weight;
        this.color = color;
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
