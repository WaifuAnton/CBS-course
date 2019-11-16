package entities;

public class ElectricityItem implements Comparable<ElectricityItem> {
    private boolean turnedOn = false;
    private int power;

    public ElectricityItem(int power) {
        this.power = power;
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

    @Override
    public int compareTo(ElectricityItem o) {
        return power - o.power;
    }
}
