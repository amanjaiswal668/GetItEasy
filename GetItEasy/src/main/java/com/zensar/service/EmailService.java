package com.zensar.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Value("${service.email}")
	private String SERVICE_EMAIL;

	@Value("${service.password}")
	private String SERVICE_EMAIL_PASSWORD;

	
	public void sendEmail(String subject, String message, String[] to) {

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(SERVICE_EMAIL, SERVICE_EMAIL_PASSWORD);
			}

		});
		
	session.setDebug(true);
	
	MimeMessage composedMessage = new MimeMessage(session);
	try {
		composedMessage.setFrom(SERVICE_EMAIL);
		InternetAddress[] addresses = {new InternetAddress(to[0]),new InternetAddress(to[1])};
		composedMessage.addRecipients(Message.RecipientType.TO, addresses);
		composedMessage.setSubject(subject);
		composedMessage.setText(message);
		
		Transport.send(composedMessage);
		
		System.out.println("Mail sent success");
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
