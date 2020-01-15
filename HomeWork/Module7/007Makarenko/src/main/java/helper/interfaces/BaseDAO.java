package helper.interfaces;

import java.util.List;

public interface BaseDAO<E> {
    int add(E entity);

    int addList(List<E> entities);

    E getById(int id);

    List<E> getAll();

    boolean delete(int id);

    boolean update(int id, E entity);
}
