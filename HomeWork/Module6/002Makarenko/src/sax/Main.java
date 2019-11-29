package sax;

import entity.Device;
import org.xml.sax.SAXException;
import sax.DeviceHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        List<Device> devices;
        try {
            SAXParser saxParser = factory.newSAXParser();
            File file = new File("src/devices.xml");
            DeviceHandler dh = new DeviceHandler();
            saxParser.parse(file, dh);
            devices = dh.getDevice();
            System.out.println(devices);
        }
        catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
        catch (SAXException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
