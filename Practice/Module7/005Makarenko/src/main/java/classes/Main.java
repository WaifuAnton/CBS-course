package classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        VolvoVehicle volvo = (VolvoVehicle) context.getBean("VolvoVehicle");
        volvo.getRadio().play();
        volvo.getWindow().move();
        volvo.getWheel().rotate();

        PlaneVehicle plane = (PlaneVehicle) context.getBean("PlaneVehicle");
        plane.getRadio().play();
        plane.getWindow().move();
        plane.getWheel().rotate();
    }
}
