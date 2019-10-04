public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Benedict", 2, true);
        Animal animal2 = new Animal("Benedict", 2, true);
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println("Are they equal? " + (animal1.equals(animal2) ? "Yes" : "No"));
        System.out.println("animal1: " + animal1.hashCode());
        System.out.println("animal2: " + animal2.hashCode());
    }
}
