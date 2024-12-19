package com.tasty.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tasty.recipe")
public class ApiRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRecipeApplication.class, args);
	}

}
