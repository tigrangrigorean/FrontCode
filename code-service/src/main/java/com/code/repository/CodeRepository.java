package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.model.entity.CodeEntity;

public interface CodeRepository extends JpaRepository<CodeEntity,Long>{
	
}
