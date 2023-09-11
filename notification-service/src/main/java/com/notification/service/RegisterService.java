package com.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	
    @KafkaListener(topics = "reg-notification", groupId = "notification-service")
	public void handleRegNotification(String username) {
		System.out.println("Hi dear " + username);
	}

}
