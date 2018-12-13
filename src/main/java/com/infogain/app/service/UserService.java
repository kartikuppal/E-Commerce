package com.infogain.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private IStoreRepo storeRepo;

	public void emailGenerator(String userName, String password, String name) {
		String to = userName/* "receive@abc.om" */; // sender email
		String from = "e.commerce0005@gmail.com"; // receiver email
		String pass = "ecom@1234";
		String host = "smtp.gmail.com"; // mail server host
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session); // email message
			message.setFrom("E-Commerce_Application"); // setting header fields
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("E-Commerce Registration"); // subject line

			// actual mail body
			message.setText("YOUR ACCOUNT IS READY\n\n\nHello " + name +",\n\n"
					+ "Thank You for registering in E-Commerce where you can spread your"
					+ " buissness in every corner of the country. Below are your"
					+ " credentials for login."
					+ "\n\n        Username is :   " + userName
					+ "\n\n        Password is :   " + password);

		
			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

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
	public Boolean loginUser(String userName, String password, Integer id) throws CustomException {
		Boolean loginSuccess = false;
		User user = userRepo.findById(id).get();
		if (user == null) {
			throw new CustomException("Email does not exist");
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
	public List<UserDto> getAllUsers() {

		List<User> user = userRepo.findAll();
		UserDto userDto = new UserDto();
		List<UserDto> userDtos = new ArrayList<>();
		for (User u : user) {
			userDto = entityToDtoAssembler(userDto, u);
			System.out.println(userDto);
			userDtos.add(userDto);
		}
		System.out.println(userDtos);
		return userDtos;
	}

	@Override
	public UserDto getUserById(Integer id) {
		UserDto userDto = new UserDto();
		User user = userRepo.findById(id).get();
		userDto = entityToDtoAssembler(userDto, user);

		return userDto;
	}

	@Override
	public UserDto insertUser(UserDto userDto) throws InvalidInputException {
		try {
			User user = new User();
			userDto.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
			user = dtoToEntityAssembler(userDto, user);
			userRepo.save(user);
			userDto.setId(user.getId());
			emailGenerator(userDto.getEmail(), userDto.getPassword(), userDto.getName());
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return userDto;
	}

	/*@Override
	public UserDto updateUser(@RequestBody @Valid UserDto userDto) throws InvalidInputException {
		try {
			User user = new User();
			
			Integer id = userDto.getId();
			
			user = userRepo.findById(id).get();
			
			System.out.println(user);
			
			user = dtoToEntityAssembler(userDto, user);
			userRepo.save(user);
		} catch (Exception e) {
			throw new InvalidInputException(e.toString());
		}
		return userDto;
	}*/
	
	@Override
	public UserDto updateUser(UserDto userDto) throws CustomException {
	try {
		User user = new User();
		Integer id = userDto.getId();
	user = userRepo.findById(id).get();
	System.out.println(user);
	user = dtoToEntityAssembler(userDto, user);
	userRepo.save(user);
	} catch (Exception e) {
	throw new InvalidInputException(e.toString());
	}
	return userDto;
	}

	
	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}
}

/**
 * @Override public Boolean loginUser(String userName, String password) throws
 *           CustomException { UserDto userDto = userRepo.findByEmail(userName);
 *           Boolean flag = false; if (userDto == null) { throw new
 *           CustomException("User Name does not exist");
 * 
 *           }
 * 
 * 
 *           else {
 * 
 *           if (userName.equals(userDto.getEmail()) &&
 *           password.equals(userDto.getPassword())) { flag = true; } } return
 *           flag; }
 * 
 * @Override public List<UserDto> getAllUsers() { List<UserDto> userDto =
 *           userRepo.findAll(); return userDto; }
 * 
 * @Override public UserDto getUserById(Integer id) { UserDto user =
 *           userRepo.findById(id).get(); return user; }
 * 
 * @Override public UserDto insertUser(UserDto userDto) throws CustomException {
 *           //User user = new User(); User existingUser =
 *           userRepo.findByEmail(userDto.getEmail()); User existingMobileNumber
 *           = userRepo.findByMobileNumber(user.getMobileNumber()); Integer
 *           addressLength = userDto.getAddress().length(); Integer
 *           mobileNumberLength = userDto.getMobileNumber().toString().length();
 *           Integer postalCodeLength =
 *           userDto.getPostalCode().toString().length(); Byte userStatus =
 *           userDto.getStatus(); List<Integer> ids = new ArrayList<>(); ids =
 *           userDto.getStoreId(); UserDto existingStore =
 *           userRepo.findById(ids);
 * 
 *           if (existingStore != null) { throw new CustomException("Store with
 *           this id already exists"); }
 * 
 *           else if (existingUser != null) { throw new CustomException("Email
 *           already exist"); }
 * 
 *           else if (existingMobileNumber != null) { throw new
 *           CustomException("Mobile number already exist"); } else if
 *           (userStatus != 1 && userStatus != 0) { throw new
 *           CustomException("Status must Either 0 for Inactive or 1 for
 *           Active"); }
 * 
 *           else if (addressLength <= 10) { throw new CustomException("Address
 *           length must be greater than 10 digits"); } else if
 *           (mobileNumberLength != 10) { throw new CustomException("Mobile
 *           number must be of exact 10 digits"); } else if (postalCodeLength !=
 *           6) { throw new CustomException("Postal code must be of exact 6
 *           digits");
 * 
 *           }
 * 
 *           else {
 * 
 *           userDto.setPassword(UUID.randomUUID().toString().replaceAll("-",
 *           "").substring(0, 8)); user.setName(userDto.getName());
 *           user.setAddress(userDto.getAddress());
 *           user.setEmail(userDto.getEmail());
 *           user.setMobileNumber(userDto.getMobileNumber());
 *           user.setPostalCode(userDto.getPostalCode());
 *           user.setStatus(userDto.getStatus()); List<Store> store = new
 *           ArrayList<>(); store = storeRepo.findAllByIdIn(ids);
 *           System.out.println(store); user.setStore(store);
 * 
 *           }
 * 
 *           return userRepo.save(userDto); }
 * 
 * @Override public User insertUser(User user) throws CustomException {
 * 
 *           User existingUser = userRepo.findByEmail(user.getEmail()); User
 *           existingMobileNumber =
 *           userRepo.findByMobileNumber(user.getMobileNumber());
 * 
 *           Integer addressLength = user.getAddress().length(); Integer
 *           mobileNumberLength = user.getMobileNumber().toString().length();
 *           Integer postalCodeLength =
 *           user.getPostalCode().toString().length();
 * 
 *           if (existingUser != null) { throw new CustomException("Email
 *           already exist"); } else if (existingMobileNumber != null) { throw
 *           new CustomException("Mobile number already exist"); } else {
 * 
 *           if (addressLength <= 10) { throw new CustomException("Address
 *           length must be greater than 10 digits"); } else if
 *           (mobileNumberLength != 10) { throw new CustomException("Mobile
 *           number must be of exact 10 digits"); } else if (postalCodeLength !=
 *           6) { throw new CustomException("Postal code must be of exact 6
 *           digits"); } else {
 *           user.setPassword(UUID.randomUUID().toString().replaceAll("-",
 *           "").substring(0, 8)); user.setName(user.getName());
 *           user.setAddress(user.getAddress()); user.setEmail(user.getEmail());
 *           user.setMobileNumber(user.getMobileNumber());
 *           user.setPostalCode(user.getPostalCode()); } } return
 *           userRepo.save(user); }
 * 
 * @Override public UserDto updateUser(UserDto userDetail, Integer id) throws
 *           CustomException { UserDto existingMobileNumber =
 *           userRepo.findByMobileNumber(userDetail.getMobileNumber()); UserDto
 *           user = userRepo.findById(id).get(); Integer passwordLength =
 *           userDetail.getPassword().length(); Integer addressLength =
 *           userDetail.getAddress().length(); Integer mobileNumberLength =
 *           userDetail.getMobileNumber().toString().length(); Integer
 *           postalCodeLength = userDetail.getPostalCode().toString().length();
 * 
 *           if (passwordLength < 8 || passwordLength > 15) { throw new
 *           CustomException("Password length must be 8 to 15 digits"); } else
 *           if (addressLength <= 10) { throw new CustomException("Address
 *           length must be greater than 10 digits"); } else if
 *           (mobileNumberLength != 10) { throw new CustomException("Mobile
 *           number must be of exact 10 digits"); } else if
 *           (existingMobileNumber != null) { throw new CustomException("Mobile
 *           number already exist"); } else if (postalCodeLength != 6) { throw
 *           new CustomException("Postal code must be of exact 6 digits");
 * 
 *           }
 * 
 *           else { user.setPassword(userDetail.getPassword());
 *           user.setName(userDetail.getName());
 *           user.setAddress(userDetail.getAddress());
 *           user.setMobileNumber(userDetail.getMobileNumber());
 *           user.setPostalCode(userDetail.getPostalCode());
 *           userRepo.save(user); } return user; }
 * 
 * 
 * 
 */