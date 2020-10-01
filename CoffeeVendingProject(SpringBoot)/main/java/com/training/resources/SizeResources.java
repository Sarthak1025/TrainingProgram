package com.training.resources;

import com.training.beans.Size;
import com.training.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SizeResources {
    @Autowired
    private SizeService sizeService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/sizes",produces = "application/json")
    public ArrayList<String> getAllSizes(){
        return sizeService.getAllSizes();
    }

    @GetMapping(path = "/sizes/{name}",produces = "application/json")
    public double getSizeRatio(@PathVariable("name")String name){
        return sizeService.getSizeRatio(name);
    }

    @GetMapping(path = "/getSize/{name}",produces = "application/json")
    public Size getSize(@PathVariable("name")String name){
        return sizeService.getSize(name);
    }
}
