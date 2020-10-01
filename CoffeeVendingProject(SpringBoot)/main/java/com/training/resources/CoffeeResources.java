package com.training.resources;

import com.training.beans.Coffee;
import com.training.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CoffeeResources {
    @Autowired
    private CoffeeService coffeeService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/coffees", produces = "application/json")
    public ArrayList<String> getAllCoffees(){
        return coffeeService.getAllCoffees();
    }

    @GetMapping(path = "/coffees/{name}", produces = "application/json")
    public int getCoffeePrice(@PathVariable("name")String name){
        return coffeeService.getCoffeePrice(name);
    }

    @GetMapping(path = "/getCoffee/{name}", produces = "application/json")
    public Coffee getCoffee(@PathVariable("name")String name){
        return coffeeService.getCoffee(name);
    }

}
