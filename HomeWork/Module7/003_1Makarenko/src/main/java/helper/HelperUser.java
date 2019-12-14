package helper;

import entity.User;

import java.util.Set;

public abstract class HelperUser<E extends User> extends Helper<E> {
    public abstract Set<E> getAll();
}
