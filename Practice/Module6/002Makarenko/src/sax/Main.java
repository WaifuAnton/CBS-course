package sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

import entity.Candy;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        CandyHandler ch = new CandyHandler();
        try {
            SAXParser saxParser = factory.newSAXParser();
            File file = new File("src/candies.xml");
            saxParser.parse(file, ch);
            Candy candy = ch.getCandy();
            System.out.println(candy);
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
