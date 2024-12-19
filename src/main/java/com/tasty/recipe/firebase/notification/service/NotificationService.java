package com.tasty.recipe.firebase.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

@Service
public class NotificationService {

	private final FirebaseMessaging firebaseMessaging;

	@Autowired
	public NotificationService(FirebaseMessaging firebaseMessaging) {
		this.firebaseMessaging = firebaseMessaging;
	}

	public void notifyAllUsers(String message) {
		// Crea y envía la notificación a todos los usuarios registrados
		Message notificationMessage = Message.builder()
				.putData("title", "Nueva receta")
				.putData("body", message)
				.setTopic("all-users") // Envía la notificación a todos los suscriptores del tema "all-users"
				.build();

		try {
			String response = firebaseMessaging.send(notificationMessage);
			System.out.println("Notificación enviada: " + response);
		} catch (FirebaseMessagingException e) {
			e.printStackTrace();
		}
	}

}
