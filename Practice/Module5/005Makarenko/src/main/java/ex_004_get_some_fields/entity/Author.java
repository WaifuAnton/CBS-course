package ex_004_get_some_fields.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@DynamicInsert
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;


    @Column(name = "last_name")
    private String lastName;

    @Column
    private String name22;

    public Author(String name) {
        this.name22 = name;
    }


    public Author(long id, String name) {
        this.id = id;
        this.name22 = name;
    }

//    public Author(long id, String lastName) {
//        this.id = id;
//        this.lastName = lastName;
//    }

    public Author() {

    }

    public Author(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName22() {
        return name22;
    }

    public void setName22(String name22) {
        this.name22 = name22;
    }
}
