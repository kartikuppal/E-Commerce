package com.infogain.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.infogain.app.repository.IUserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = UserServiceImpl.class)
public class UserServiceTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private IUserRepo userRepo;
	
	@Test
	public void getAll()
	{
		
	}

}
