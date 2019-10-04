package Task2;

public class Main {
    public static void main(String[] args) {
        Car unknownCar = new Car(),
                unknownCarWithAge = new Car(4),
                knownCar = new Car("Audi"),
                knownCarWithAge = new Car("Mrazeratti", 2);
        Car[] cars = new Car[]
                { unknownCar, unknownCarWithAge, knownCar, knownCarWithAge };
        for (Car car : cars)
            car.showInfo();
    }
}
