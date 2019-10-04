public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]
                {
                        new Circle(),
                        new Rectangle()
                };
        for (Shape shape : shapes)
            shape.draw();
    }
}
