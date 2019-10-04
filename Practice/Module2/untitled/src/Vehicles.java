public enum Vehicles {
    Volvo(10000), Mercedes(500000), Renault(15000);

    private int price = 10000;
    private String color = "black";

    private Vehicles(int price)
    {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle: " + super.toString() + "; color: " + color + "; price: " + price;
    }
}
