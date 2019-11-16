package dao;

import entities.ElectricityItem;

import java.util.List;

public interface DAO {
    void add(ElectricityItem item);
    void remove(int id);
    ElectricityItem getByID(int id);
    List<ElectricityItem> getAll();
}
