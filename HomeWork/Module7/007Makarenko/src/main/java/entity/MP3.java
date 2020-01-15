package entity;

import javax.persistence.*;

@Entity
public class MP3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String song = "unknown";

    @Column(name = "author_id")
    private int authorId;

    public MP3() {
    }

    public MP3(int authorId) {
        this.authorId = authorId;
    }

    public MP3(String song) {
        this.song = song;
        authorId = 1;
    }

    public MP3(String song, int authorId) {
        this.song = song;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return song;
    }
}
