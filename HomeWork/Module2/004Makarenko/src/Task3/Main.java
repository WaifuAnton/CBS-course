package Task3;

public class Main {
    public static void main(String[] args) {
        Playable player = new Player();
        Recordable recorder = new Player();

        recorder.record();
        recorder.pause();
        recorder.record();
        recorder.stop();

        player.play();
        player.pause();
        player.play();
        player.stop();
    }
}
