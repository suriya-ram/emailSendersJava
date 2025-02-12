package com.example.SpringEmail;

import com.example.SpringEmail.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailApplication {

	 @Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailApplication.class, args);}

		@EventListener (ApplicationReadyEvent.class)
		public void triggerEmail() throws MessagingException {
           emailService.SendEmailWithAttachment("suriyaram234.zra@gmail.com",
				   "this is the mail body",
				   " some subject",
				   "C:\\Users\\suriya\\OneDrive\\Pictures\\Screenshots\\1.jpg");
		}




}
