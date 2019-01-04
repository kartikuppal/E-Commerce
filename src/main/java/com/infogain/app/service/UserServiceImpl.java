package com.infogain.app.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String emailFrom;
	
	@Override
	public void activation(Integer id) {
		User user = userRepo.findById(id).get();
		user.setStatus((byte) 1);
		userRepo.save(user);
	}
	
	
	public void forgetPassword(String email)
	{
		
		
	}
	@Override
	public String sendMail(String userName, String password, String name, Integer id) throws UnsupportedEncodingException {
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);


		try {
			message.setFrom(new InternetAddress());
			String uri = "";
			message.setContent("<h1>Registeration Successfull !</h1>"
					+ "YOUR ACCOUNT IS READY<br><br><br>Hello " + name + "   ,<br><br>"
					+ "Thank You for registering in E-Commerce where you can spread your"
					+ " buissness in every corner of the country. Below are your" + " credentials for login."
					+ "<br><br>        Username is :   " + userName + "<br><br>        Password is :   " + password
					+ "<br><br><body><a href=http://localhost:8083/api/activateAccount/"+id+">Click here to Activate Your Account</a></body>", "text/html");
			helper.setTo(userName);
			helper.setFrom(new InternetAddress(emailFrom,"E-Commerce"));
			helper.setSubject("E-Commerce Registration");

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		mailSender.send(message);
		return "Mail Sent Success!";
	}

	@Override
	public UserDto entityToDtoAssembler(UserDto userDto, User user) {
		userDto.setId(user.getId());
		userDto.setAddress(user.getAddress());
		userDto.setEmail(user.getEmail());
		userDto.setMobileNumber(user.getMobileNumber());
		userDto.setPassword(user.getPassword());
		userDto.setPostalCode(user.getPostalCode());
		userDto.setName(user.getName());
		userDto.setStatus((byte) user.getStatus());

		return userDto;
	}

	@Override
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
			throw new InvalidInputException(500,"User Name does not exist");
		} else {
			if (userName.equals(user.getEmail()) && password.equals(user.getPassword())) {
				loginSuccess = true;
			} else {
				throw new InvalidInputException(500,"Login not successfull");
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
			
			logger.info("display>>>>>>>>>>>>");
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

	@Override


	public UserDto insert(UserDto userDto) throws InvalidInputException {
	
			if(userDto.getPassword()!=null)
			{
				throw new InvalidInputException(404,"User cannot create password");

			}
		
			else if(userDto.getStatus()!=null)
			{
				throw new InvalidInputException(404,"Status cannot add status ");
			}
			
			try {
			User user = new User();
			userDto.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
			user = dtoToEntityAssembler(userDto, user);
			user.setStatus((byte) 0);
			userDto.setStatus((byte) 0);
			userRepo.save(user);
			userDto.setId(user.getId());
			sendMail(userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getId());
		} catch (Exception e) {
			throw new InvalidInputException(400,"Email already exist");
		}
		return userDto;
	} 

	@Override
	public UserDto update(UserDto userDto) throws InvalidInputException {
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
	public String delete(Integer id) {
		userRepo.deleteById(id);
		return "User with id " +id+ " is Removed";
	}
}
