package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.Candy;

public class CandyHandler extends DefaultHandler {
    private String currentQName;
    private Candy candy;

    public CandyHandler() {
        candy = new Candy();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentQName = qName;
        if (qName.equals("candy"))
            candy.setHasSugar(!attributes.getValue(0).equals("no"));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentQName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        switch (currentQName) {
            case "name":
                candy.setName(value);
                break;
        }
    }

    public Candy getCandy() {
        return candy;
    }
}
