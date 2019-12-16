import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PlaneVehicle extends Vehicle implements BeanPostProcessor {
    public PlaneVehicle(Window window, Radio radio, Wheel wheel) {
        this.radio = radio;
        this.wheel = wheel;
        this.window = window;
    }

    public PlaneVehicle(Radio radio) {
        this.radio = radio;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("PlaneVehicle object is being created\n");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("PlaneVehicle object has been created\n");
        return o;
    }
}
