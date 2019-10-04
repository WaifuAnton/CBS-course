package Task2;

public class Car {
    private String name;
    private int year;

    public Car()
    {
        name = "Car... probably";
        year = 0;
    }

    public Car(int year)
    {
        this.year = year;
        name = "Car... probably";
    }

    public Car(String name)
    {
        this.name = name;
        year = 0;
    }

    public Car(String name, int year)
    {
        this.name = name;
        this.year = year;
    }

    public void showInfo()
    {
        System.out.println(name + ", " + year + " years");
    }
}
