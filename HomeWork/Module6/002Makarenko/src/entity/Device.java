package entity;

import java.util.ArrayList;
import java.util.List;

public class Device {
    private String name;
    private Type type;
    private String origin;
    private double price;
    private int power;
    private boolean hasCooler;
    private Group group;
    private List<String> ports;

    public Device() {
        ports = new ArrayList<>(1);
    }

    public Type getType() {
        return type;
    }

    public String getOrigin() {
        return origin;
    }

    public double getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

    public boolean isHasCooler() {
        return hasCooler;
    }

    public Group getGroup() {
        return group;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

     public void setPrice(double price) {
        this.price = price;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setHasCooler(boolean hasCooler) {
        this.hasCooler = hasCooler;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "; " + type + "; " + origin + "; " + price + "USD; " + group + "; " + power + "W; " +
                (hasCooler ? "has a cooler; " : "doesn't have a cooler; ") + "ports: " + ports.toString();
    }
}
