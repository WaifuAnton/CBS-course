package entity;

public class Salt {
    private int id;
    private int user;
    private String value;

    public Salt(int user, String value) {
        this.user = user;
        this.value = value;
    }
}
