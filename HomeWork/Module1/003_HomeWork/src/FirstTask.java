public class FirstTask {
    public static void main(String[] args) {
        int x = 10, y = 12, z = 3;
        x += y - x++ * z;
        System.out.println(x);
        z = --x - y * 5;
        System.out.println(z);
        y /= x + 5 % z;
        System.out.println(y);
        z = x++ + y * 5;
        System.out.println(z);
        x = y - x++ * z;
        System.out.println(x);
    }
}
