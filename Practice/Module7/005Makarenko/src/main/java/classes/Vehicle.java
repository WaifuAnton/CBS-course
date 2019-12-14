package classes;

import interfaces.Radio;
import interfaces.Wheel;
import interfaces.Window;

public abstract class Vehicle {
    protected Window window;
    protected Radio radio;
    protected Wheel wheel;

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
