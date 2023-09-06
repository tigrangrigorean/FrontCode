package com.auth.service.impl;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.auth.exception.UserNotFoundException;
import com.auth.exception.WrongPasswordException;
import com.auth.model.dto.UserAuthData;
import com.auth.model.entity.UserEntity;
import com.auth.repository.UserRepository;
import com.auth.service.AuthService;
import com.auth.service.token.JwtTokenUtils;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	private final JwtTokenUtils jwtTokenUtils;
	
	public AuthServiceImpl(UserRepository userRepository,JwtTokenUtils jwtTokenUtils) {
		this.userRepository = userRepository;
		this.jwtTokenUtils = jwtTokenUtils;
	}

	@Override
	public String authenticate(UserAuthData userAuthData) {
		
    	String token = null;
    	
		UserEntity userEntity = userRepository.findUserEntityByUsername(userAuthData.getUsername());
		if(userEntity == null) {
			throw new UserNotFoundException(userAuthData.getUsername());
		}
		
    	boolean passwordMatch = userAuthData.getPassword().equals(userEntity.getPassword());

    	if(passwordMatch) {
    		token = jwtTokenUtils.generateToken(userEntity);
    	}
    	if(token == null) {
    		throw new WrongPasswordException("Entered Password is Wrong");
    	}
		
		return token;
	}


}
