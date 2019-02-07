package com.infogain.app.security;

import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.stereotype.Controller;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.Role;
import com.infogain.app.entity.User;
import com.infogain.app.exception.InvalidInputException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Controller
public class JwtTokenDecoder {
	String secret = "secret";
	
	public UserDto decode(String token)
	{
		UserDto userDto = new UserDto();
		try{
			Claims body = Jwts.parser().
					setSigningKey(secret).
					parseClaimsJws(token).getBody();
			
			userDto.setId((Integer) body.get("id"));
			userDto.setEmail(body.getSubject());
			userDto.setPassword((String) body.get("password"));
			userDto.setRole((List<Role>) body.get("role"));
			
			/*claim ch jo v set hunda LinkedHashMap di form ch hunda aa 
			  ess krke jdo v odr Role da arrayList retrieve krna fer pehla 
			  sanu edro Role nu LinkedHashMap ch convert krna pena */
			
		}
		
		catch (Exception e) {
			throw new InvalidInputException(401,"Invalid token");
		}
		return userDto;
		
	}

}
