package entities;

public class ElectricityItem implements Comparable<ElectricityItem> {
    private boolean turnedOn = false;
    private int power = 0;
    private int id = 0;
    protected String name = "unknown";

    public ElectricityItem(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void turnOn() {
        turnedOn = true;
    }

    public void turnOff() {
        turnedOn = false;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public int getPower() {
        return power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(ElectricityItem o) {
        return power - o.power;
    }
}
