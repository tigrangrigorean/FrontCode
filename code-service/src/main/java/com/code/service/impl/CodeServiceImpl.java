package com.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.controller.requests.RequestForGetAuthenticatedUsername;
import com.code.exception.AccessDeniedException;
import com.code.exception.CodeNotFoundException;
import com.code.model.dto.AddCodeDto;
import com.code.model.entity.CodeEntity;
import com.code.repository.CodeRepository;
import com.code.repository.UserRepository;
import com.code.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService {
	
	private final CodeRepository codeRepository;
	private final RequestForGetAuthenticatedUsername requestUsername;
	private final UserRepository userRepository;
	
	public CodeServiceImpl(CodeRepository codeRepository,RequestForGetAuthenticatedUsername requestUsername,
			UserRepository userRepository) {
		this.codeRepository = codeRepository;
		this.requestUsername = requestUsername;
		this.userRepository = userRepository;
	}

	@Override
	public CodeEntity getById(long id) {
		return codeRepository.findById(id).orElseThrow(
				() -> new CodeNotFoundException("Code by id " + id + " not found"));
	}

	@Override
	public List<CodeEntity> getAll() {
		return codeRepository.findAll();
	}

	@Override
	public void add(AddCodeDto code) {
		CodeEntity codeEntity = new CodeEntity();
		codeEntity.setTitle(code.getTitle());
		codeEntity.setSnippet(code.getSnippet());
		codeEntity.setLike(0);
		codeEntity.setUserEntity(userRepository.findUserEntityByUsername(requestUsername.getUsername()));
		codeRepository.save(codeEntity);
	}

	@Override
	public void update(long id,AddCodeDto code) {
		
		CodeEntity codeEntity = codeRepository.findById(id).orElseThrow(
				() -> new CodeNotFoundException("Code by id " + id + " not found"));
		
		if(!requestUsername.getUsername().equals(codeEntity.getUserEntity().getUsername())) {
			throw new AccessDeniedException("Access Denied");
		}
		
		if(code.getTitle() != null) {
			codeEntity.setTitle(code.getTitle());
		}
		if(code.getSnippet() != null) {
			codeEntity.setSnippet(code.getSnippet());
		}
		codeRepository.save(codeEntity);
	}

	@Override
	public void deleteById(long id) {
		
		CodeEntity codeEntity = codeRepository.findById(id).orElseThrow(
				() -> new CodeNotFoundException("Code by id " + id + " not found"));
		
		userRepository.deleteById(id);
	}
	
	@Override
	public void incrementLikes(long id) {
		CodeEntity codeEntity = codeRepository.findById(id).orElseThrow(
				() -> new CodeNotFoundException("Code by id " + id + " not found"));
		
		long likeCount = codeEntity.getLike();
		codeEntity.setLike(++likeCount);
		codeRepository.save(codeEntity);
	}
	
	@Override
	public void decrementLikes(long id) {
		CodeEntity codeEntity = codeRepository.findById(id).orElseThrow(
				() -> new CodeNotFoundException("Code by id " + id + " not found"));
		
		long likeCount = codeEntity.getLike();
		codeEntity.setLike(--likeCount);
		codeRepository.save(codeEntity);
	}

}
