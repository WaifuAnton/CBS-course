import java.sql.Time;
import java.time.LocalTime;

public class Animal {
    private String name = "Piotor";
    private int years = 36;
    private boolean tail = false;

    public Animal() { }

    public Animal(String name, int years, boolean tail)
    {
        this.name = name;
        this.tail = tail;
        this.years = years;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal temp = (Animal)obj;
            boolean result = (temp.tail == tail) && (temp.years == years) && (temp.name.equals(name));
            return result;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; age: " + years + "; tail: " + (tail ? "Yes" : "No");
    }

    @Override
    public int hashCode() {
        int result = 42;
        result = 42 * (tail ? 1 : 10) + years * 8;
        result += name.length() + 12345 * 6;
        result += LocalTime.now().getNano();
        return result;
    }
}
