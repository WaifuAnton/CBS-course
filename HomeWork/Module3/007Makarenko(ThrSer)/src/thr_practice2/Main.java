package thr_practice2;

public class Main {
    public static void main(String[] args) {
        ThreadDaemon daemon1 = new ThreadDaemon();
        ThreadDaemon daemon2 = new ThreadDaemon();
        ThreadDaemon daemon3 = new ThreadDaemon();
        Normal normal = new Normal();
        normal.start();
        daemon1.start();
        daemon2.start();
        daemon3.start();
    }
}
