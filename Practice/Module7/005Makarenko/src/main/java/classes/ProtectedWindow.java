package classes;

import interfaces.Window;

public class ProtectedWindow implements Window {
    public void move() {
        System.out.println("Can't move");
    }
}
