package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findUserEntityByUsername(String username);
	
}
