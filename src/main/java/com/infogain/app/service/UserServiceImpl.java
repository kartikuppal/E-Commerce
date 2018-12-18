package com.infogain.app.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.infogain.app.dto.StoreDto;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.Store;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private IStoreRepo storeRepo;
	@Autowired
	JavaMailSender mailSender;

	public void activation(Integer id) {
		User user = userRepo.findById(id).get();
		user.setStatus((byte) 1);
		userRepo.save(user);
	}

	public String sendMail(String userName, String password, String name, Integer id) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		BodyPart messageBodyPart = new MimeBodyPart();
		try {

			message.setContent("<h1>Registeration Successfull !</h1>"

					+ "YOUR ACCOUNT IS READY<br><br><br>Hello " + name + "   ,<br><br>"
					+ "Thank You for registering in E-Commerce where you can spread your"
					+ " buissness in every corner of the country. Below are your" + " credentials for login."
					+ "<br><br>        Username is :   " + userName + "<br><br>        Password is :   " + password
					+ "<br><br><body><a href=http://localhost:8083/api/activateAccount/"+id+">Click here to Activate Your Account</a></body>", "text/html");
			helper.setTo(userName);
			helper.setSubject("E-Commerce Registration");

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		mailSender.send(message);
		return "Mail Sent Success!";
	}

	/*
	  public void emailGenerator(String userName, String password, String name)
	  { String to = userName; // sender email String from =
	  "e.commerce0005@gmail.com"; // receiver email String pass = "ecom@1234";
	  String host = "smtp.gmail.com"; // mail server host Properties properties
	  = System.getProperties(); properties.put("mail.smtp.starttls.enable",
	  "true"); properties.setProperty("mail.smtp.host", host);
	  properties.setProperty("mail.smtp.auth", "true");
	  
	  Session session = Session.getDefaultInstance(properties, new
	  javax.mail.Authenticator() { protected PasswordAuthentication
	  getPasswordAuthentication() { return new PasswordAuthentication(from,
	  pass); } }); try { MimeMessage message = new MimeMessage(session); //
	  email message message.setFrom(new
	  InternetAddress(from,"E-Commerce Application")); // setting header fields
	  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	  message.setSubject("E-Commerce Registration"); // subject line
	  
	  // actual mail body message.setText("YOUR ACCOUNT IS READY\n\n\nHello " +
	  name + "   ,\n\n" +
	  "Thank You for registering in E-Commerce where you can spread your"
	  
	  + " buissness in every corner of the country. Below are your" +
	  " credentials for login." + "\n\n        Username is :   " + userName +
	  "\n\n        Password is :   " + password);
	  
	  
	  Transport.send(message);
	  
	  } catch (MessagingException | UnsupportedEncodingException mex) {
	  mex.printStackTrace(); } }
	 */

	public UserDto entityToDtoAssembler(UserDto userDto, User user) {
		userDto.setId(user.getId());
		userDto.setAddress(user.getAddress());
		userDto.setEmail(user.getEmail());
		userDto.setMobileNumber(user.getMobileNumber());
		userDto.setPassword(user.getPassword());
		userDto.setPostalCode(user.getPostalCode());
		userDto.setName(user.getName());
		userDto.setStatus(user.getStatus());

		return userDto;
	}

	public User dtoToEntityAssembler(UserDto userDto, User user) {
		user.setAddress(userDto.getAddress());
		user.setEmail(userDto.getEmail());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setPassword(userDto.getPassword());
		user.setPostalCode(userDto.getPostalCode());
		user.setName(userDto.getName());
		user.setStatus(userDto.getStatus());

		return user;
	}

	@Override
	public Boolean login(String userName, String password, Integer id) throws CustomException {
		Boolean loginSuccess = false;
		User user = userRepo.findById(id).get();
		String existingEmail = user.getEmail();
		if (!existingEmail.equals(userName)) {
			throw new CustomException("User Name does not exist");
		} else {

			if (userName.equals(user.getEmail()) && password.equals(user.getPassword())) {
				loginSuccess = true;
			} else {
				throw new CustomException("Login not successfull");
			}
		}
		return loginSuccess;
	}

	@Override
	public List<UserDto> getAll() {

		List<User> userList = userRepo.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		for (User user : userList) {
			UserDto userDto = new UserDto();
			userDto = entityToDtoAssembler(userDto, user);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public UserDto getById(Integer id) {
		UserDto userDto = new UserDto();
		User user = userRepo.findById(id).get();
		userDto = entityToDtoAssembler(userDto, user);
		return userDto;
	}

	public UserDto insert(UserDto userDto) throws InvalidInputException {
		try {
			User user = new User();
			userDto.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
			user = dtoToEntityAssembler(userDto, user);
			userDto.setStatus((byte) 0);
			userRepo.save(user);
			userDto.setId(user.getId());
			sendMail(userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getId());
			
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return userDto;
	} 

	@Override
	public UserDto update(UserDto userDto) throws CustomException {
		try {
			User user = userRepo.findById(userDto.getId()).get();
			user = dtoToEntityAssembler(userDto, user);
			userRepo.save(user);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return userDto;
	}

	@Override
	public void delete(Integer id) {
		userRepo.deleteById(id);
	}
}
