import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath path = pathFactory.newXPath();
        File file = new File("src/devices.xml");
        try {
            XPathExpression expression = path.compile("//device/name | //device/origin | //device/price | //device/type");
            InputSource source = new InputSource(new FileInputStream(file));
            NodeList list = (NodeList) expression.evaluate(source, XPathConstants.NODESET);
            for (int i = 0; i < list.getLength(); i++) {
                System.out.println("Tag \"" + list.item(i).getNodeName() + "\": " + list.item(i).getTextContent());
                for (int j = 0; j < list.item(i).getAttributes().getLength(); j++)
                    System.out.println("Attribute \"" + list.item(i).getAttributes().item(j).getNodeName() + "\": " +
                            list.item(i).getAttributes().item(j).getTextContent());
                if (list.item(i).getNodeName().equals("type"))
                    System.out.println();
            }
        }
        catch (XPathExpressionException e) {
            e.getCause();
        }
        catch (FileNotFoundException e) {
            e.getCause();
        }
    }
}
