package br.com.carstore.servlet.service;

import br.com.carstore.servlet.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public Car save(Car car) {
        car.setId(idCounter++);
        cars.add(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car update(Long id, Car car) {
        for (Car c : cars) {
            if (c.getId().equals(id)) {
                c.setName(car.getName());
                c.setBrand(car.getBrand());
                c.setYear(car.getYear());
                return c;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        cars.removeIf(c -> c.getId().equals(id));
    }
}