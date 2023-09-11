package com.userservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.userservice.controller.requests.RequestForGetAuthenticatedUsername;
import com.userservice.model.dto.UserDto;
import com.userservice.model.dto.UserDtoForUpdate;
import com.userservice.model.entity.UserEntity;
import com.userservice.model.enumeration.Role;
import com.userservice.model.enumeration.UsageType;
import com.userservice.model.exception.InvalidPasswordException;
import com.userservice.model.exception.UserNotFoundException;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import com.userservice.service.validator.Validator;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	private final RequestForGetAuthenticatedUsername requestUsername;
    private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,RequestForGetAuthenticatedUsername requestUsername,
			KafkaTemplate<String, String> kafkaTemplate) {
		this.userRepository = userRepository;
		this.requestUsername = requestUsername;
		this.encoder = new BCryptPasswordEncoder();
		this.kafkaTemplate = kafkaTemplate;
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
		kafkaTemplate.send("reg-notification",userEntity.getUsername());
	}

	@Override
	public void update(long id, UserDtoForUpdate userDto) {
		UserEntity userEntity = userRepository.findById(id).orElseThrow(
				() -> new UserNotFoundException("User by entered id not found")
				);
		
		if(userDto.getUsername() != null && Validator.checkUsername(userDto.getUsername())) {
			userEntity.setUsername(userDto.getUsername());
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

	@Override
	public void changePassword(String lastPassword, String newPassword, String repeatPassword) {
		
		UserEntity userEntity = userRepository.findUserEntityByUsername(requestUsername.getUsername());
		
		boolean passwordMatch = BCrypt.checkpw(lastPassword, userEntity.getPassword());
		
		if(passwordMatch) {
			if(newPassword.equals(repeatPassword)) {
				userEntity.setPassword(encoder.encode(newPassword));
				userRepository.save(userEntity);
			}else {
			throw new InvalidPasswordException("Repeated password is wrong");
			}
		} else {
			throw new InvalidPasswordException("Entered last password is wrong");
		}
		
	}

}
