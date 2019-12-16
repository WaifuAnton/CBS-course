public class VolvoVehicle extends Vehicle {
    public VolvoVehicle(Window window, Radio radio, Wheel wheel) {
        this.radio = radio;
        this.wheel = wheel;
        this.window = window;
    }

    public void initialize() {
        System.out.println("VolvoVehicle.initialize");
    }

    public void destroy() {
        System.out.println("VolvoVehicle.destroy");
    }
}
