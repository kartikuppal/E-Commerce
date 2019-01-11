package com.infogain.app.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String emailFrom;

	public String activeStatusMail(String userName, String password, String name, Integer id)
			throws UnsupportedEncodingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			message.setFrom(new InternetAddress());
			message.setContent("<h1>Registeration Successfull !</h1>" + "YOUR ACCOUNT IS READY<br><br><br>Hello " + name
					+ "   ,<br><br>" + "Thank You for registering in E-Commerce where you can spread your"
					+ " buissness in every corner of the country. Below are your" + " credentials for login."
					+ "<br><br>        Username is :   " + userName + "<br><br>        Password is :   " + password
					+ "<br><br><body><a href=http://localhost:8083/api/userActivation/" + id
					+ ">Click here to Activate Your Account</a></body>", "text/html");
			helper.setTo(userName);
			helper.setFrom(new InternetAddress(emailFrom, "E-Commerce"));
			helper.setSubject("E-Commerce Registration");

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		mailSender.send(message);
		return "Mail Sent Success!";
	}

	public String forgetPasswordMail(String email, HttpServletRequest request, String token) throws Exception {
		String url = request.getScheme()+"://"+request.getServerName()+":8083/api/forgetPassword/"+token;
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			message.setFrom(new InternetAddress());
			message.setContent("<h1>Reset Password</h1>" 
					+ "<br><br><body><a href="+url
					+ ">Click here to Reset Password</a></body>", "text/html");
			helper.setTo(email);
			helper.setFrom(new InternetAddress(emailFrom, "E-Commerce"));
			helper.setSubject("Forget password !!");

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		mailSender.send(message);
		return "Mail Sent Success!";

	}

}
