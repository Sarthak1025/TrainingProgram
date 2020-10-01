package com.training.service;

import java.util.ArrayList;

import com.sun.xml.internal.messaging.saaj.util.CharReader;
import com.training.beans.Coffee;
import com.training.persistence.CoffeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService{
	@Autowired
	private CoffeeDao coffeeDao;
	@Override
	public ArrayList<String> getAllCoffees() {
		ArrayList<Coffee> coffees = (ArrayList<Coffee>) coffeeDao.findAll();
		ArrayList<String> coffeeNames = new ArrayList<>();
		for (Coffee coffee: coffees){
			coffeeNames.add(coffee.getCoffeeName());
		}
		return coffeeNames;
	}

	@Override
	public int getCoffeePrice(String name) {
		ArrayList<Coffee> coffees = (ArrayList<Coffee>) coffeeDao.findAll();
		int price=0;
		for (Coffee coffee: coffees){
			if (coffee.getCoffeeName().equalsIgnoreCase(name)){
				price = coffee.getBasePrice();
				break;
			}
		}
		return price;
	}

	@Override
	public Coffee getCoffee(String name) {
		return coffeeDao.getCoffeeByCoffeeName(name);
	}
}
