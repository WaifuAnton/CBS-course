package entity;

public class WashingMachine extends ElectricityItem {
    int maxClothesWeight;

    public WashingMachine(String name, int power, int maxClothesWeight, double rentCost, double totalCost) {
        super(power, rentCost, totalCost);
        super.name = name;
        this.maxClothesWeight = maxClothesWeight;
    }

    public int getMaxClothesWeight() {
        return maxClothesWeight;
    }
}