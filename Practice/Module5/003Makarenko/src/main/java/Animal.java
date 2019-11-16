import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Animal {
    @Id
    private int id;
    private String name = "none";
    private boolean isPredator = false;
    private int weight = 0;
    private String region = "none";

    public Animal() { }

    public Animal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
