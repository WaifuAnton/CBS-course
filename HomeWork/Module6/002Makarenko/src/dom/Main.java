package dom;

import entity.Device;
import entity.Group;
import entity.Type;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeviceHelper dh = new DeviceHelper();
        List<Device> devices = dh.getAll();
        System.out.println(devices);

        Device device = new Device();
        device.setGroup(Group.IO);
        device.setHasCooler(false);
        device.setPower(1);
        device.setType(Type.PERIPHERAL);
        device.setName("mouse");
        device.setOrigin("China");
        device.setPrice(12);
        device.getPorts().add("usb");
        dh.addDevice(device);
    }
}
