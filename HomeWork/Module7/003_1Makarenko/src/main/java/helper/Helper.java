package helper;

import entity.ElectricityItem;

import java.util.List;

public interface Helper <E> {
    List<E> getAll();

    E getById(long id);

    void add(E element);

    void update(long id, E element);
}
