package com.auth.service.token;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth.model.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils {
	
	private String secret = "randomsecretkey";
	private long expirationTime = 86400000;
	
	public String generateToken(UserEntity userEntity) {
	   
	    Map<String, Object> claims = new HashMap<>();
	    List<String> rolesList = userEntity.getAuthorities();

	    claims.put("roles", rolesList);

	    return Jwts.builder()
	            .setClaims(claims)
	            .setSubject(userEntity.getUsername())
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
	            .signWith(SignatureAlgorithm.HS256, secret)
	            .compact();
	}
	
	public String getName(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}
	
	public List<String> getRoles(String token) {
		return getAllClaimsFromToken(token).get("roles", List.class);
	}
	
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();

}

}