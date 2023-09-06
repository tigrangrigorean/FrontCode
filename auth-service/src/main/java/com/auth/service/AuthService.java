package com.auth.service;

import com.auth.model.dto.UserAuthData;

public interface AuthService {
	
	String authenticate(UserAuthData userAuthData);
	
}
