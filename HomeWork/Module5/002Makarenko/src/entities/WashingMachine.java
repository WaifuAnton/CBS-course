package entities;

public class WashingMachine extends ElectricityItem {
    int maxClothesWeight;

    public WashingMachine(int power, int maxClothesWeight) {
        super(power);
        this.maxClothesWeight = maxClothesWeight;
    }

    public int getMaxClothesWeight() {
        return maxClothesWeight;
    }
}
