public class Monitor extends Device {
    private int resolutionX = 0, resolutionY = 0;

    public Monitor() { }

    public Monitor(String manufacturer, double price, String serialNumber, int resolutionX, int resolutionY)
    {
        super(manufacturer, price, serialNumber);
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
    }

    public Monitor(String manufacturer, double price, String serialNumber)
    {
        super(manufacturer, price, serialNumber);
        this.resolutionX = 1920;
        this.resolutionY = 1080;
    }

    public int getResolutionX() {
        return resolutionX;
    }

    public int getResolutionY() {
        return resolutionY;
    }

    @Override
    public String toString() {
        return "Monitor: manufacturer = " + getManufacturer() + ", price = " + getPrice() +", serialNumber = " + getSerialNumber() +
                ", X = " + resolutionX + ", Y = " + resolutionY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Monitor)
        {
            boolean result;
            Monitor temp = (Monitor) obj;
            result = getManufacturer().equals(temp.getManufacturer()) && (getPrice() == temp.getPrice()) &&
                    (resolutionX == temp.resolutionX) && (resolutionY == temp.resolutionY);
            return result;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 16;
    }
}
