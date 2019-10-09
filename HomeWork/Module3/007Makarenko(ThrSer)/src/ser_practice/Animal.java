package ser_practice;

import java.io.Serializable;

public class Animal implements Serializable {
    private String species = "human";
    private double weight = 60;
    private int age = 22;

    public Animal() { }

    public Animal(String species, int age, double weight) {
        this.species = species;
        this.age = age;
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
