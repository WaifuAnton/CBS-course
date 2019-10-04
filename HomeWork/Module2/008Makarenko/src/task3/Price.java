package task3;

public class Price {
    private String itemName;
    private String shopName;
    private double price;

    public Price(String itemName, String shopName, double price) {
        this.itemName = itemName;
        this.shopName = shopName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return itemName + " is sold in " + shopName + ", its price is " + price + "UAH";
    }
}
