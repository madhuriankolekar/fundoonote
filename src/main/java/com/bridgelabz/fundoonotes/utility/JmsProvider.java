package com.bridgelabz.fundoonotes.utility;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class JmsProvider {
	@Autowired
	private static JavaMailSender javaMailSender ;

	public static void sendEmail(String toEmail, String subject, String body) {

	String fromEmail = "ankolekarmadhuri16@gmail.com";
	String password = "madhuriankolekar";

	Properties prop = new Properties();
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.starttls.enable", "true");
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.port", "587");

	Authenticator auth = new Authenticator() {
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(fromEmail, password);
	}
	};
	Session session = Session.getInstance(prop, auth);
	send(session, fromEmail, toEmail, subject, body);
	}

	private static void send(Session session, String fromEmail, String toEmail, String subject, String body) {
	try {
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress(fromEmail,"madhuri"));
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	message.setSubject(subject);
	message.setText(body);
	Transport.send(message);
	//javaMailSender.send(message);
	} catch (Exception e) {
	e.printStackTrace();
	System.out.println("can not send mail  ");

	}
	}
	}
		
	




