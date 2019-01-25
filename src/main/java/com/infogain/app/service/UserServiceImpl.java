package com.infogain.app.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.infogain.app.dto.StoreDto;
import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.Role;
import com.infogain.app.entity.Store;
import com.infogain.app.entity.User;
import com.infogain.app.exception.CustomException;
import com.infogain.app.exception.InvalidInputException;
import com.infogain.app.repository.IRoleRepo;
import com.infogain.app.repository.IStoreRepo;
import com.infogain.app.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());

	@Autowired
	private IRoleRepo roleRepo;
	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private IStoreRepo storeRepo;
	@Autowired
	EmailService emailService;

	@Value("${spring.mail.username}")
	private String emailFrom;

	@Cacheable("first")
	public Integer getRedis(Integer name)
	{
		System.out.println("hello "+ name);
		return name;
	}
	
	public UserDto login(String userName, String password) throws InvalidInputException
	{
		UserDto userDto = new UserDto();
		User user = userRepo.findByEmail(userName);
		if(user==null)
		{
			throw new InvalidInputException(400,"Email does not exists");
		}
		else if(!user.getPassword().equals(password))
		{
			throw new InvalidInputException(400,"password does not match");
		}
		
		userDto = entityToDtoAssembler(userDto, user);
		return userDto;
		
	}
	
	@Override
	public void activation(Integer id) {
		User user = userRepo.findById(id).get();
		user.setStatus((byte) 1);
		userRepo.save(user);
	}

	public List<UserDto> getActiveUsers() {
		List<User> userList = userRepo.getActiveUsers();
		List<UserDto> userDtoList = new ArrayList<>();
		for (User user : userList) {
			UserDto userDto = new UserDto();
			userDto = entityToDtoAssembler(userDto, user);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	public List<String> getActiveUserName() {
		List<String> names = userRepo.getActiveUsersName();
		return names;
	}

	public void forgetPassword(String email, HttpServletRequest request) throws Exception {

		String token;
		User user = new User();
		user = userRepo.findByEmail(email);

		if (user == null) {
			throw new CustomException("Email does not exist");
		} else {

			token = UUID.randomUUID().toString();
			user.setForgetPasswordToken(token);
			userRepo.save(user);
			emailService.forgetPasswordMail(email, request, token);

		}
	}

	public String resetPassword(String token, String newPassword) {
		User user = userRepo.findByForgetPasswordToken(token);
		if (!token.equals(user.getForgetPasswordToken())) {
			throw new InvalidInputException(505, "Security Breach !!! Cant change Password");
		} else {
			user.setPassword(newPassword);
			user.setForgetPasswordToken(null);
			userRepo.save(user);
		}
		return newPassword;

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
		userDto.setLastLogin(user.getLastLogin());

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
			throw new InvalidInputException(500, "User Name does not exist");
		} else if (user.getStatus() == 0) {
			throw new InvalidInputException(500, "Your Account is not activated yet");
		} else {
			if (userName.equals(user.getEmail()) && password.equals(user.getPassword())) {

				loginSuccess = true;
				SimpleDateFormat dateFormat = new SimpleDateFormat("E dd-MMMM-YYYY HH:mm:ss zzz");
				Date date = new Date();
				user.setLastLogin(dateFormat.format(date));
				userRepo.save(user);

			} else {
				throw new InvalidInputException(500, "Login not successfull");
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

	/*
	 * @Override public UserDto getById(Integer id) { UserDto userDto = new
	 * UserDto(); User user = userRepo.findById(id).get(); userDto =
	 * entityToDtoAssembler(userDto, user); return userDto; }
	 */
	
	@Override
	public UserDto getById(Integer id) {
		UserDto userDto = new UserDto();
		User user = userRepo.findById(id).get();
		userDto = entityToDtoAssembler(userDto, user);
		
		/*List<Store> storeList = storeRepo.findAll();

		List<StoreDto> storeDtoList = new ArrayList<>();
		for (Store store : storeList) 
		{
			StoreDto storeDto = new StoreDto();
			storeDto.setId(store.getId());
			storeDto.setName(store.getName());
			storeDto.setAddress(store.getAddress());
			storeDto.setPostalCode(store.getPostalCode());
			storeDto.setContactNo(store.getContactNo());
			storeDtoList.add(storeDto);
		}
		userDto.setStoreList(storeDtoList);*/
		return userDto;
	}

	@Override
	public UserDto insert(UserDto userDto) throws InvalidInputException {
		User user = new User();
		user = userRepo.findByEmail(userDto.getEmail());
		if(user != null)
		{
			throw new InvalidInputException(404,"UserName already exist");
		}
		else if (userDto.getPassword() != null) {
			throw new InvalidInputException(404, "User cannot create password");

		}

		else if (userDto.getStatus() != null) {
			throw new InvalidInputException(404, "Status cannot add status ");
		}

		try {
			userDto.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
			user = dtoToEntityAssembler(userDto, user);
			user.setStatus((byte) 0);
			userDto.setStatus((byte) 0);
			//Setting role as user by default
			List<Role> roles = new ArrayList<>();
			List<Integer> ids = new ArrayList<>();
			ids.add(1);
			roles = roleRepo.findByIdIn(ids);
			user.setRole(roles);
			userRepo.save(user);
			userDto.setId(user.getId());
			userDto.setRole(roles);
			emailService.activeStatusMail(userDto.getEmail(), userDto.getPassword(), userDto.getName(),
					userDto.getId());
		} catch (Exception e) {
			throw new InvalidInputException(400, "Something went Wrong");
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
		return "User with id " + id + " is Removed";
	}
}
