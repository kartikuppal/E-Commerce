package com.infogain.app.authorization;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.infogain.app.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator
{
	public String generateToken(User user) 
	{
			Date date = new Date();
		    long currentTime = date.getTime();
		    Date expirationTime = new Date(currentTime + 600000l); 
		Claims claims=Jwts.claims().
				setSubject(user.getEmail());
		claims.put("email", user.getEmail());
		claims.put("password", user.getPassword());
		
		return Jwts.builder().setSubject(user.getEmail()).setClaims(claims).setIssuedAt(date)
				.setExpiration(expirationTime)
	            .signWith(SignatureAlgorithm.HS256, "secret").compact();
		
	}
}
