package com.userservice.service;

import java.util.List;
import java.util.Optional;

import com.userservice.model.dto.UserDto;
import com.userservice.model.entity.UserEntity;

public interface UserService {
	
	UserEntity getUserById(long id);
	List<UserEntity> getAll();
	void register(UserDto userDto);
	void update(long id, UserDto userDto);
	void deleteById(long id);
	
}
