package com.userservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.userservice.model.dto.UserDto;
import com.userservice.model.entity.UserEntity;
import com.userservice.model.enumeration.Role;
import com.userservice.model.enumeration.UsageType;
import com.userservice.model.exception.UserNotFoundException;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import com.userservice.service.validator.Validator;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.encoder = new BCryptPasswordEncoder();
	}

	@Override
	public UserEntity getUserById(long id) {
		 return userRepository.findById(id)
		            .orElseThrow(() -> new UserNotFoundException("User by id " + id + " not found"));
	}

	@Override
	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void register(UserDto userDto) {
		Validator.checkUser(userDto);
		Validator.checkEmail(userDto.getEmail());
		Validator.checkUsername(userDto.getUsername());
		Validator.checkPassword(userDto.getPassword());
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userDto.getUsername());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setPassword(encoder.encode(userDto.getPassword()));
		userEntity.setRole(Role.USER);
		userEntity.setUsageType(UsageType.NORMAL);
		userRepository.save(userEntity);
	}

	@Override
	public void update(long id, UserDto userDto) {
		UserEntity userEntity = userRepository.findById(id).orElseThrow(
				() -> new UserNotFoundException("User by entered id not found")
				);
		
		if(userDto.getUsername() != null && Validator.checkUsername(userDto.getUsername())) {
			userEntity.setUsername(userDto.getUsername());
		}
		if(userDto.getPassword() != null && Validator.checkPassword(userDto.getPassword())) {
			userEntity.setPassword(encoder.encode(userDto.getPassword()));
		}
		if(userDto.getEmail() != null && Validator.checkEmail(userDto.getEmail()) ) {
			userEntity.setEmail(userDto.getEmail());
		}
		userRepository.save(userEntity);
	}

	@Override
	public void deleteById(long id) {
		UserEntity userEntity = userRepository.findById(id).orElseThrow(
				() -> new UserNotFoundException("User by entered id not found")
				);
		
		userRepository.delete(userEntity);
	}

}
