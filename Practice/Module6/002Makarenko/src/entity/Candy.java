package entity;

public class Candy {
    private String name;
    private boolean hasSugar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }

    public void setHasSugar(boolean hasSugar) {
        this.hasSugar = hasSugar;
    }

    @Override
    public String toString() {
        return name + (hasSugar ? " with sugar" : " without sugar");
    }
}
