package classes;

import interfaces.Radio;
import interfaces.Wheel;
import interfaces.Window;

public class VolvoVehicle extends Vehicle {
    public VolvoVehicle(Window window, Radio radio, Wheel wheel) {
        this.radio = radio;
        this.wheel = wheel;
        this.window = window;
    }
}
