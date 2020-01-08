package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salt {
    @Id
    private int id;
    private int user;
    private String value;

    public Salt() { }

    public Salt(int user, String value) {
        this.user = user;
        this.value = value;
    }
}
