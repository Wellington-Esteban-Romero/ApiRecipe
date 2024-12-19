package com.tasty.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasty.recipe.Dto.Recipe;
import com.tasty.recipe.firebase.notification.service.NotificationService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	private NotificationService notificationService;

//	@Autowired
//	public RecipeController(NotificationService notificationService) {
//		this.notificationService = notificationService;
//	}

	@PostMapping("/addRecipe")
	public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
		notificationService.notifyAllUsers("Nueva receta añadida: " + recipe.getTitle());
		return ResponseEntity.ok("Receta añadida con éxito.");
	}

}
