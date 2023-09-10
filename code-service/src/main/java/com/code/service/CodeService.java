package com.code.service;

import java.util.List;

import com.code.model.dto.AddCodeDto;
import com.code.model.entity.CodeEntity;

public interface CodeService {
	
	CodeEntity getById(long id);
	List<CodeEntity> getAll();
	void add(AddCodeDto code);
	void update(long id,AddCodeDto code);
	void deleteById(long id);
	void incrementLikes(long id);
	void decrementLikes(long id);
}
