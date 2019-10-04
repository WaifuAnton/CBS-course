public class EthernetAdapter extends Device {
    private int maxSpeed = 0;
    private String mac = "No mac";

    public EthernetAdapter() { }

    public EthernetAdapter(String manufacturer, double price, String serialNumber, String mac)
    {
        super(manufacturer, price, serialNumber);
        this.mac = mac;
        this.maxSpeed = 300;
    }

    public EthernetAdapter(String manufacturer, double price, String serialNumber, String mac, int maxSpeed)
    {
        super(manufacturer, price, serialNumber);
        this.mac = mac;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getMac() {
        return mac;
    }

    @Override
    public String toString() {
        return "Ethernet adapter: manufacturer = " + getManufacturer() + ", price = " + getPrice() +", serialNumber = " + getSerialNumber() +
                ", maxSpeed " + maxSpeed + ", mac " + mac;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EthernetAdapter)
        {
            boolean result;
            EthernetAdapter temp = (EthernetAdapter) obj;
            result = getManufacturer().equals(temp.getManufacturer()) && (getPrice() == temp.getPrice()) &&
                    (maxSpeed == temp.maxSpeed) && mac.equals(temp.mac);
            return result;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 8;
    }
}
