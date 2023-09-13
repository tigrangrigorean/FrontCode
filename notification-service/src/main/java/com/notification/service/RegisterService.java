package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	
	private final EmailService emailService;
	
	@Autowired
	public RegisterService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	/**
	 * info[1] is User Email
	 * info[0] is User Activation Code
	 * @param codeAndMail
	 */
    @KafkaListener(topics = "reg-notification", groupId = "notification-service")
	public void handleRegNotification(String codeAndMail) {
    	String[] info = codeAndMail.split(" ");
    	emailService.sendSimpleMessage(info[1].substring(0, info[1].length()-1), "Activation Code", "Your activation code is " + info[0].substring(1));
	}

}
