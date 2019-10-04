package Task3;

public class Player implements Recordable, Playable {
    public void play() {
        System.out.println("Video is being played");
    }

    public void pause() {
        System.out.println("The process is paused");
    }
    public void stop() {
        System.out.println("The process is stopped");
    }

    public void record() {
        System.out.println("Video is being recorded");
    }
}
