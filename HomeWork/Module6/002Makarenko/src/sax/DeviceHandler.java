package sax;

import entity.Device;
import entity.Group;
import entity.Type;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class DeviceHandler extends DefaultHandler {
    private List<Device> devices;
    private int lastIndex = -1;
    private String currentQName;

    public DeviceHandler() {
        devices = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentQName = qName;
        if (attributes.getLength() > 0) {
            switch (attributes.getValue("group")) {
                case "io":
                    devices.get(lastIndex).setGroup(Group.IO);
                    break;
                case "multimedia":
                    devices.get(lastIndex).setGroup(Group.MULTIMEDIA);
                    break;
            }
            devices.get(lastIndex).setHasCooler(!(attributes.getValue("has_cooler").equals("false")));
            String portSet = attributes.getValue("ports");
            String[] ports = portSet.split(", ");
            for (int i = 0; i < ports.length; i++)
                devices.get(lastIndex).getPorts().add(ports[i]);
            devices.get(lastIndex).setPower(Integer.parseInt(attributes.getValue("power")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentQName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        switch (currentQName) {
            case "type":
                if (value.equals("main"))
                    devices.get(lastIndex).setType(Type.MAIN);
                else
                    devices.get(lastIndex).setType(Type.PERIPHERAL);
                break;
            case "name":
                devices.get(lastIndex).setName(value);
                break;
            case "origin":
                devices.get(lastIndex).setOrigin(value);
                break;
            case "price":
                devices.get(lastIndex).setPrice(Double.parseDouble(value));
                break;
            case "device":
                devices.add(new Device());
                lastIndex++;
        }
    }

    public List<Device> getDevice() {
        return devices;
    }
}
