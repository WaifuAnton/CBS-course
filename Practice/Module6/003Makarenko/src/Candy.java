import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candy")
public class Candy {
    private String hasSugar;
    private String name = "none";

    public Candy() { }

    public Candy(String name, String hasSugar) {
        this.hasSugar = hasSugar;
        this.name = name;
    }

    public String getHasSugar() {
        return hasSugar;
    }

    @XmlAttribute(name = "has_sugar")
    public void setHasSugar(String hasSugar) {
        this.hasSugar = hasSugar;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + (!hasSugar.equals("no") ? " with sugar" : " without sugar");
    }
}
