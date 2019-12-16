package entity;

public class Kettle extends ElectricityItem {
    int liters;

    public Kettle(String name, int power, int liters, double rentCost, double totalCost) {
        super(power, rentCost, totalCost);
        super.name = name;
        this.liters = liters;
    }

    public int getLiters() {
        return liters;
    }
}
