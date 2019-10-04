package Task3;

public class Main {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1000),
                new Car("Almost Silver"),
                new Car(),
                new Car(1500, "Pink"),
                new Car(2000, 5, "Deep Blue"),
                new Car(700, 1, 234.67976, "White")
        };
        for(Car car : cars)
            car.showInfo();
    }
}
