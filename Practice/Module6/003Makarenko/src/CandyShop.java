import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "candy_shop")
public class CandyShop {
    private List<Candy> candies;

    public List<Candy> getCandies() {
        return candies;
    }

    @XmlElement(name = "candy")
    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    public CandyShop() {
        candies = new ArrayList<>();
    }

    public void add(Candy candy) {
        candies.add(candy);
    }

    @Override
    public String toString() {
        return candies.toString();
    }
}
