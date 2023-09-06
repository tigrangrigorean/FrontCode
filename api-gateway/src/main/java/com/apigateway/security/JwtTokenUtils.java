package com.apigateway.security;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtils {
	
	private String secret = "randomsecretkey";
	
	public String getName(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}
	
	public List<String> getRoles(String token) {
		return getAllClaimsFromToken(token).get("roles", List.class);
	}
	
	
	Claims getAllClaimsFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();

}
	

    public boolean validateToken(String authToken) {
        return getAllClaimsFromToken(authToken)
                .getExpiration()
                .after(new Date());
    }


}
