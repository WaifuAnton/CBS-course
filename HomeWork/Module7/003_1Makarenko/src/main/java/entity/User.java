package entity;

public class User {
    private String login = "";
    private String password;
    private double value = 1;
    private double id = 0;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public User(String login, String password, double value) {
        this.login = login;
        this.password = password;
        this.value = value;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
