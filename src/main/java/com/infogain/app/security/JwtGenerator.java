package com.infogain.app.security;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator
{
	public String generateToken(UserDto userDto) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss ");
			Date date = new Date();
		   // long currentTime = date.getTime();
		    
		Claims claims=Jwts.claims().
				setSubject(userDto.getEmail());
		claims.put("id", userDto.getId());
		claims.put("email", userDto.getEmail());
		claims.put("password", userDto.getPassword());
		claims.put("role", userDto.getRole());
		
		return Jwts.builder().setSubject(userDto.getEmail()).setClaims(claims).setIssuedAt(date)
				.setExpiration(new Date(System.currentTimeMillis() + (1 * 1000)))
	            .signWith(SignatureAlgorithm.HS256, "secret").compact();
		
		/*return Jwts.builder().setSubject(userDto.getEmail()).setClaims(claims)
	            .signWith(SignatureAlgorithm.HS256, "secret").compact();*/
		
	}
}
