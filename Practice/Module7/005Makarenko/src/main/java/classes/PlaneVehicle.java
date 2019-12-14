package classes;

import interfaces.Radio;
import interfaces.Wheel;
import interfaces.Window;

public class PlaneVehicle extends Vehicle {
    public PlaneVehicle(Window window, Radio radio, Wheel wheel) {
        this.radio = radio;
        this.wheel = wheel;
        this.window = window;
    }
}
