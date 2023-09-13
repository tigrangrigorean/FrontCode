package com.userservice.service;

import java.util.List;
import com.userservice.model.dto.UserDto;
import com.userservice.model.dto.UserDtoForUpdate;
import com.userservice.model.entity.UserEntity;

public interface UserService {
	
	UserEntity getUserById(long id);
	List<UserEntity> getAll();
	void register(UserDto userDto);
	void update(long id, UserDtoForUpdate userDtoForUpdate);
	void deleteById(long id);
	void changePassword(String lastPassword, String newPassword, String repeatPassword);
	void activateAccount(String email,String number);
	
}
