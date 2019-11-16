package entities;

public class WashingMachine extends ElectricityItem {
    int maxClothesWeight;

    public WashingMachine(String name, int power, int maxClothesWeight) {
        super(power);
        super.name = name;
        this.maxClothesWeight = maxClothesWeight;
    }

    public int getMaxClothesWeight() {
        return maxClothesWeight;
    }
}
