package com.userservice.service.validator;

import org.springframework.stereotype.Component;

import com.userservice.model.dto.UserDto;
import com.userservice.model.entity.UserEntity;
import com.userservice.model.exception.ActivationException;
import com.userservice.model.exception.IncorrectUsernameException;
import com.userservice.model.exception.InvalidEmailException;
import com.userservice.model.exception.InvalidPasswordException;

import jakarta.persistence.EntityNotFoundException;

@Component
public class Validator {

	public static boolean checkEntity(UserEntity userEntity) {
		if (userEntity == null) {
			throw new EntityNotFoundException("User not found");
		}
		return true;
	}
	
	public static boolean checkUser(UserDto userDto) {
		if(userDto == null) {
			throw new IllegalArgumentException("Entered Object is interrupted");
		}
		return true;
	}

	public static boolean checkUsername(String username) {
		  String regex = "^[a-zA-Z]+$";
	        if (!username.matches(regex)) {
	            throw new IncorrectUsernameException("Username is incorrect. Enter only latin letters");
	        }
	        return true;
	}
	public static boolean checkPassword(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-/*+=])(?=\\S+$).{8,}$";
		if (!password.matches(regex)) {
			throw new InvalidPasswordException("Entered password is invalid, please make sure you have"
					+ " provided at least one digit, one lowercase, one uppercase, one special character");
		}
		return true;
	}

	public static boolean checkEmail(String email) {
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z]+\\.[A-Za-z]{2,}$";
		if (!email.matches(regex)) {
			throw new InvalidEmailException(
					"Entered email is invalid, please make sure you have" + " entered correct email");
		}
		return true;
	}
	
    public static boolean checkActivation(boolean activated) {
        if (activated == false) {
            throw new ActivationException("Account by entered e-mail isn't activated");
        }
        return true;
    }
	
}
