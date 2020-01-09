package entity;

import javax.persistence.*;

@Entity(name = "items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ElectricityItem implements Comparable<ElectricityItem> {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id = 0;
    private boolean inUse = false;
    private int power = 0;
    protected String name = "unknown";
    private double totalCost = 0;
    private String type = getClass().getName();;

    public ElectricityItem() { }

    public ElectricityItem(int power, double totalCost) {
        this.power = power;
        this.totalCost = totalCost;
    }

    public String getName() {
        return name;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
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

    public void setPower(int power) {
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public int compareTo(ElectricityItem o) {
        return power - o.power;
    }

    public String getType() {
        return type;
    }
}
