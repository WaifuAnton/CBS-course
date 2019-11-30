package animal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String species = "none";
    private boolean isPredator = false;
    private String region = "none";
    private int weight = 0;

    public Animal() { }

    public Animal(String species, String region, int weight, boolean isPredator) {
        this.species = species;
        this.region = region;
        this.weight = weight;
        this.isPredator = isPredator;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public String getRegion() {
        return region;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal other = (Animal) obj;
            boolean equals = (weight == other.weight) && (isPredator == other.isPredator) &&
                    region.equals(other.region) && species.equals(other.species);
            return equals;
        }
        return false;
    }
}
