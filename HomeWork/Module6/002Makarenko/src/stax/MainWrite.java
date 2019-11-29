package stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrite {
    public static void main(String[] args) {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        try {
            FileWriter fWriter = new FileWriter("output.xml");
            XMLStreamWriter xmlWriter = factory.createXMLStreamWriter(fWriter);
            xmlWriter.writeStartDocument();

            xmlWriter.writeStartElement("device");
            xmlWriter.writeCharacters("hhh");
            xmlWriter.writeEndElement();

            xmlWriter.writeEndDocument();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
    }
}
