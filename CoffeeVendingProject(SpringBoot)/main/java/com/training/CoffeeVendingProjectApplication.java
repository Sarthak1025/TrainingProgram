package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.training")
public class CoffeeVendingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeVendingProjectApplication.class, args);
	}

}
