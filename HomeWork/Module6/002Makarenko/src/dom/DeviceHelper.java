package dom;

import entity.Device;
import entity.Group;
import entity.Type;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeviceHelper {
    private Document document;

    public DeviceHelper() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse("src/devices.xml");
            System.out.println(document);
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

    public void addDevice(Device dev) {
        Element devices = document.getDocumentElement();
        Element device = document.createElement("device");
        Element name = document.createElement("name");
        Element origin = document.createElement("origin");
        Element price = document.createElement("price");
        Element type = document.createElement("type");

        name.setTextContent(dev.getName());
        origin.setTextContent(dev.getOrigin());
        price.setTextContent(String.valueOf(dev.getPrice()));
        if (dev.getType() == Type.MAIN)
            type.setTextContent("main");
        else if (dev.getType() == Type.PERIPHERAL)
            type.setTextContent("peripheral");

        type.setAttribute("has_cooler", !dev.isHasCooler() ? "false" : "true");
        if (dev.getGroup() == Group.MULTIMEDIA)
            type.setAttribute("group", "multimedia");
        else if (dev.getGroup() == Group.IO)
            type.setAttribute("group", "io");
        type.setAttribute("power", String.valueOf(dev.getPower()));
        String ports = "";
        for (int i = 0; i < dev.getPorts().size() - 1; i++)
            ports += dev.getPorts().get(i) + ", ";
        ports += dev.getPorts().get(dev.getPorts().size() - 1);
        type.setAttribute("ports", ports);

        device.appendChild(name);
        device.appendChild(origin);
        device.appendChild(price);
        device.appendChild(type);

        devices.appendChild(device);

        DOMSource source = new DOMSource(document);
        String outputURL = "src/devices.xml";

        StreamResult result = null;
        try {
            result = new StreamResult(new FileOutputStream(outputURL));
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(source, result);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public List<Device> getAll() {
        List<Device> allDevices = new ArrayList<>();
        Element devices = document.getDocumentElement();
        NodeList list = document.getElementsByTagName("device");
        for (int i = 0; i < list.getLength(); i++) {
            Device device = new Device();
            String name = list.item(i).getFirstChild().getNextSibling().getTextContent();
            String origin = list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent();
            double price = Double.parseDouble(list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent());
            Type type = Type.PERIPHERAL;
            switch (list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent()) {
                case "peripheral":
                    type = Type.PERIPHERAL;
                    break;
                case "main":
                    type = Type.MAIN;
                    break;
            }
            System.out.println(list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getAttributes().item(1).getTextContent());
            Group group = Group.IO;
            switch (list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getAttributes().item(0).getTextContent()) {
                case "io":
                    group = Group.IO;
                    break;
                case "multimedia":
                    group = Group.MULTIMEDIA;
                    break;
            }
            int power = Integer.parseInt(list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getAttributes().item(3).getTextContent());
            boolean hasCooler = !list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getAttributes().item(1).getTextContent().equals("false");
            String portSet =list.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getAttributes().item(2).getTextContent();
            String[] ports = portSet.split(", ");
            for (int j = 0; j < ports.length; j++)
                device.getPorts().add(ports[j]);
            device.setPrice(price);
            device.setOrigin(origin);
            device.setName(name);
            device.setType(type);
            device.setPower(power);
            device.setHasCooler(hasCooler);
            device.setGroup(group);
            allDevices.add(device);
        }
        return allDevices;
    }
}
