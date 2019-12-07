package entity;

import java.util.Objects;

/**
 * Created by Asus on 31.01.2018.
 */
public class Client {

    private long id = 0;
    private String name = "none";
    private int age = 0;
    private String phone = "none";
    private String password = "hidden";

    public Client(int id, String name, int age, String phone, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.password = password;
    }

    public Client(int id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Client() { }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + "  " + name + "  " + age + "  " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age &&
                name.equals(client.name) &&
                phone.equals(client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phone);
    }
}
