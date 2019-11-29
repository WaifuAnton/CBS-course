package stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainRead {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/devices.xml");
            XMLInputFactory xmlInput = XMLInputFactory.newFactory();
            XMLStreamReader xmlReader = xmlInput.createXMLStreamReader(reader);
            while (xmlReader.hasNext())
                switch (xmlReader.next()) {
                    case XMLStreamReader.START_ELEMENT:
                        String elem = xmlReader.getName().toString();
                        if (elem.equals("device"))
                            System.out.print("New device: ");
                        else if (elem.equals("name"))
                            System.out.println(xmlReader.getElementText());
                        break;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
