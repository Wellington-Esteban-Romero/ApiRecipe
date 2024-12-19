package com.tasty.recipe.firebase;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@Configuration
public class FirebaseConfig {

	@Bean
	public FirebaseMessaging firebaseMessaging() throws IOException {
		FileInputStream serviceAccount =
				new FileInputStream("src/main/resources/firebase/google-services.json");
		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();
		FirebaseApp app = FirebaseApp.initializeApp(options);
		return FirebaseMessaging.getInstance(app);
	}

}
