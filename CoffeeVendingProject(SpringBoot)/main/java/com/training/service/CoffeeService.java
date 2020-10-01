package com.training.service;

import com.training.beans.Coffee;

import java.util.ArrayList;

public interface CoffeeService {
	ArrayList<String> getAllCoffees();
	int getCoffeePrice(String name);
	Coffee getCoffee(String name);
}
