import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vehicles[] vehicles = new Vehicles[]
                {
                        Vehicles.Volvo,
                        Vehicles.Mercedes,
                        Vehicles.Renault
                };
        Scanner scanner = new Scanner(System.in);
        String color;
        for (int i = 0; i < vehicles.length; i++) {
            color = scanner.next();
            vehicles[i].setColor(color);
            System.out.println(vehicles[i]);
            System.out.println();
        }
    }
}
