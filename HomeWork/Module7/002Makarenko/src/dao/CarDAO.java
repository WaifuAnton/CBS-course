package dao;

import java.util.List;

import entity.Car;

public interface CarDAO {
    
    void add(Car car);
    
    List<Car> getAll();
    
    Car getById(int id);
    
    void updatePrice(int price, int carId);
    
    void remove(String mark);
    
}
