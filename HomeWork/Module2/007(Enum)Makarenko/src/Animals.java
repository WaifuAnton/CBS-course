public enum Animals {
    LION(5), ELEPHANT(13), CAT(3), DOG(4);

    private int age;

    private Animals(int age)
    {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + " WITH THE AGE OF " + age;
    }
}
