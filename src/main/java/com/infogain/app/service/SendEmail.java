package com.infogain.app.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	@Autowired
	private JavaMailSender mailSender;
	
public String sendMail(String userName, String password, String name, Integer id) throws UnsupportedEncodingException {
		
		//String from = "E-Commerce";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);


		try {
			message.setFrom(new InternetAddress());
			message.setContent("<h1>Registeration Successfull !</h1>"

					+ "YOUR ACCOUNT IS READY<br><br><br>Hello " + name + "   ,<br><br>"
					+ "Thank You for registering in E-Commerce where you can spread your"
					+ " buissness in every corner of the country. Below are your" + " credentials for login."
					+ "<br><br>        Username is :   " + userName + "<br><br>        Password is :   " + password
					+ "<br><br><body><a href=http://localhost:8083/api/activateAccount/"+id+">Click here to Activate Your Account</a></body>", "text/html");
			helper.setTo(userName);
			//helper.setFrom(new InternetAddress(from,"E-Commerce"));
			helper.setSubject("E-Commerce Registration");

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		mailSender.send(message);
		return "Mail Sent Success!";
	}


}
