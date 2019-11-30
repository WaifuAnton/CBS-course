import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        CandyShop candyShop = new CandyShop();
        candyShop.add(new Candy("White chocolate", "yes"));
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CandyShop.class);
            File file = new File("C:\\Users\\makar\\Desktop\\Прога\\Попочка\\Java\\CBS course\\Practice\\Module6\\003Makarenko\\src\\candies.xml");

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(candyShop, file);
            marshaller.marshal(candyShop, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            candyShop = (CandyShop) unmarshaller.unmarshal(file);
            System.out.println(candyShop);
        }
        catch (JAXBException e) {
            System.out.println(e.getCause());
        }
    }
}
