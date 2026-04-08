package br.com.carstore.servlet.controller;

import br.com.carstore.servlet.model.Car;
import br.com.carstore.servlet.service.CarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    private final CarService service;

    public CarRestController(CarService service) {
        this.service = service;
    }
    @GetMapping
    public List<Car> listar() {
        return service.findAll();
    }
    @PostMapping
    public Car salvar(@RequestBody Car car) {
        return service.save(car);
    }
    @PutMapping("/{id}")
    public Car atualizar(@PathVariable Long id, @RequestBody Car car) {
        return service.update(id, car);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deleteById(id);
    }
}