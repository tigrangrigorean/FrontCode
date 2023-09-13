package com.userservice.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.userservice.service.GenerationService;

@Service
public class GenerationServiceImpl implements GenerationService{
	
	private String number;
	
	public GenerationServiceImpl() {
		
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	@Override
	public String generate() {
		Random random = new Random();
		this.number = String.valueOf(random.nextInt(1000000) + 1);
		return number;
	}

}
