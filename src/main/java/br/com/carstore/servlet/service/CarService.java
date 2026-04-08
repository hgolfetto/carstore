package br.com.carstore.servlet.service;

import br.com.carstore.servlet.model.Car;
import java.util.List;

public interface CarService {

    Car save(Car car);
    List<Car> findAll();

    Car update(Long id, Car car);
    void deleteById(Long id);
}