package practice;

public class Animal implements Comparable { // <Animal>{
    private String breed;
    private int weight;
    private int speed;
    private int price;

    Animal(String breed, int weight, int speed, int price) {
        this.breed = breed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    public String toString() {
        return this.breed + " " + this.weight + " " + this.speed + " " + this.price;
    }

    // Сортируем по скорости/цене
    public int compareTo(Object o) {              //    public int compareTo(Animal o) {
        int tmpSp = this.speed - ((Animal)o).speed; //    int tmp = this.speed - o.speed;
        int tmpW = weight - ((Animal)o).weight;
        int tmpPr = price - ((Animal)o).price;
        int tmpBr = breed.compareTo(((Animal)o).breed);
        if (tmpSp != 0)
            return tmpSp;
        else if (tmpW != 0)
            return tmpW;
        else if (tmpPr != 0)
            return tmpPr;
        else
            return tmpBr;
    }

    // Сравнение 2-х строковых значений
    // return this.breed.compareTo(((Animal)o).breed);
}
