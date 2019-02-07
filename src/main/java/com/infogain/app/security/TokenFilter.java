package com.infogain.app.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class TokenFilter extends  AbstractAuthenticationProcessingFilter {

	protected TokenFilter() {
		super("/auth/*");
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
	
		String token = getToken(request);
		
		return null;
	}
	
	public String getToken(HttpServletRequest request)
	{
		String token = request.getHeader("Authorrization");
		if(token==null)
		{
			throw new RuntimeException("Token is missing");
		}
		
		return token;
		
	}
	

}
