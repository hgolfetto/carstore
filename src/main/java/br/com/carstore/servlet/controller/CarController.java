package br.com.carstore.servlet.controller;

import br.com.carstore.servlet.model.Car;
import br.com.carstore.servlet.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cars", service.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String save(Car car) {
        service.save(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}