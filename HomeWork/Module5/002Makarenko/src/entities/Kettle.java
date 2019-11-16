package entities;

public class Kettle extends ElectricityItem {
    int liters;

    public Kettle(String name, int power, int liters) {
        super(power);
        super.name = name;
        this.liters = liters;
    }

    public int getLiters() {
        return liters;
    }
}
