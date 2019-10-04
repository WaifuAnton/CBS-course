import java.sql.Time;
import java.time.LocalTime;

public class Device {
    private String manufacturer = "No one";
    private double price = 0;
    private String serialNumber = "No number";

    public Device() { }

    public Device(String manufacturer, double price, String serialNumber)
    {
        this.manufacturer = manufacturer;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Device: manufacturer = " + manufacturer + ", price = " + price +", serialNumber = " + serialNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Device)
        {
            boolean result;
            Device temp = (Device) obj;
            result = manufacturer.equals(temp.manufacturer) && (price == temp.price) && serialNumber.equals(temp.serialNumber);
            return result;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return LocalTime.now().getNano();
    }
}
