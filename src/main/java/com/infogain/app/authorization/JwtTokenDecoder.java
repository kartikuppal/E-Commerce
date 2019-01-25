package com.infogain.app.authorization;

import org.springframework.stereotype.Controller;
import com.infogain.app.entity.User;
import com.infogain.app.exception.InvalidInputException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Controller
public class JwtTokenDecoder {
	String secret = "secret";
	
	public User decode(String token)
	{
		User user = new User();
		try{
			Claims body = Jwts.parser().
					setSigningKey(secret).
					parseClaimsJws(token).getBody();
			
			user.setEmail(body.getSubject());
			user.setPassword((String) body.get("password"));
			
		}
		
		catch (Exception e) {
			throw new InvalidInputException(401,"Invalid token");
		}
		return user;
		
	}

}
