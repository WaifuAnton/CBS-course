package entity;

import java.util.Objects;

public class User implements Comparable<User> {
    private String login = "";
    private int discountProgram = 0;
    private double value = 1;
    private double id = 0;
    private String auth_str = "";

    public String getAuth_str() {
        return auth_str;
    }

    public void setAuth_str(String auth_str) {
        this.auth_str = auth_str;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getDiscountProgram() {
        return discountProgram;
    }

    public double getValue() {
        return value;
    }

    public void setDiscountProgram(int discountProgram) {
        switch (discountProgram) {
            case 1:
                value = 0.95;
                break;
            case 2:
                value = 0.9;
                break;
            case 3:
                value = 0.8;
                break;
            default:
                value = 1;
        }
        this.discountProgram = discountProgram;
    }

    @Override
    public int compareTo(User o) {
        return login.compareTo((o.login));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
