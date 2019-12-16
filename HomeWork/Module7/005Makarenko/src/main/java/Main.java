import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("t23.xml");
        VolvoVehicle volvo = (VolvoVehicle) context.getBean("VolvoVehicle");
        volvo.getRadio().play();
        volvo.getWindow().move();
        volvo.getWheel().rotate();

        PlaneVehicle plane = (PlaneVehicle) context.getBean("PlaneVehicle");
    }
}
