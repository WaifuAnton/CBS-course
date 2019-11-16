package entities;

public class Kettle extends ElectricityItem {
    int liters;

    public Kettle(int power, int liters) {
        super(power);
        this.liters = liters;
    }

    public int getLiters() {
        return liters;
    }
}
