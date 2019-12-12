package entity;

public class ElectricityItem implements Comparable<ElectricityItem> {
    private boolean turnedOn = false;
    private int power = 0;
    private long id = 0;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(ElectricityItem o) {
        return power - o.power;
    }
}
