package Task2;

public class BadPupil extends Pupil {
    @Override
    public void read() {
        System.out.println("Awful reading");
    }

    @Override
    public void relax() {
        System.out.println("Why are you even here?");
    }

    @Override
    public void study() {
        System.out.println("Awful relaxing");
    }

    @Override
    public void write() {
        System.out.println("Awful writing");
    }
}
