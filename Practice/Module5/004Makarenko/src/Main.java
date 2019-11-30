import animal.Animal;
import animal.AnimalRepository;

public class Main {
    public static void main(String[] args) {
        Animal zebra = new Animal("zebra", "Africa", 400, false);
        AnimalRepository repository = new AnimalRepository();
        repository.remove(1);
        repository.remove(2);
        repository.remove(3);
    }
}
