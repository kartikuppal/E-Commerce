/*package com.infogain.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TUserController {
	@Autowired
	AbstractTest abstractTest;
	@Test
	public void getProductsList() throws Exception {
	   String uri = "/products";
	   MvcResult mvcResult = abstractTest.mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   User[] userList = super.mapFromJson(content, User[].class);
	   assertTrue(productlist.length > 0);
	}
}
*/