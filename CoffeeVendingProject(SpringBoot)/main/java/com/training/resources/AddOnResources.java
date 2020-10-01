package com.training.resources;

import com.training.beans.AddOn;
import com.training.service.AddOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AddOnResources {
    @Autowired
    private AddOnService addOnService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/addOns", produces = "application/json")
    public ArrayList<String> getAllAddOns(){
        return addOnService.getAllAddOns();
    }

    @GetMapping(path = "/addOns/{name}", produces = "application/json")
    public int getAddOnPrice(@PathVariable("name")String name){
        return addOnService.getAddOnPrice(name);
    }

    @GetMapping(path = "/getAddOn/{name}", produces = "application/json")
    public AddOn getAddOn(@PathVariable("name")String name){
        return addOnService.getAddOn(name);
    }
}
