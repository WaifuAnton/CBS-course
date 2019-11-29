package stax;

import entity.Candy;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        Candy candy = new Candy();
        try {
            Reader reader = new FileReader("src/candies.xml");
            XMLStreamReader xmlReader = factory.createXMLStreamReader(reader);
            while (xmlReader.hasNext()) {
                if (xmlReader.next() == XMLStreamReader.START_ELEMENT) {
                    String element = xmlReader.getName().toString();
                    switch (element) {
                        case "candy":
                            boolean hasSugar = !xmlReader.getAttributeValue(0).equals("no");
                            candy.setHasSugar(hasSugar);
                            break;
                        case "name":
                            String name = xmlReader.getElementText();
                            candy.setName(name);
                            break;
                    }
                }
            }
            System.out.println(candy);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
    }
}
