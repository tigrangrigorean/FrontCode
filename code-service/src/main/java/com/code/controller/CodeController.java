package com.code.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.code.model.dto.AddCodeDto;
import com.code.model.entity.CodeEntity;
import com.code.service.CodeService;

@RestController
@RequestMapping("/codes")
public class CodeController {
	
	private final CodeService codeService;
	
	public CodeController(CodeService codeService) {
		this.codeService = codeService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CodeEntity> getById(@PathVariable long id) {
		return ResponseEntity.ok().body(codeService.getById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CodeEntity>> getAll() {
		return ResponseEntity.ok().body(codeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody AddCodeDto code) {
		codeService.add(code);
		return ResponseEntity.status(201).body("Code added");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestParam long id,@RequestBody AddCodeDto code) {
		codeService.update(id, code);
		return ResponseEntity.ok("Code Updated");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteById(@RequestParam long id) {
		codeService.deleteById(id);
		return ResponseEntity.ok("Code deleted");
	}
	
	@PostMapping("/likes/increment")
	public ResponseEntity<String> incrementLikes(@RequestParam long id) {
		codeService.incrementLikes(id);
		return ResponseEntity.ok("Likes count incremented");
	}
	
	@PostMapping("/likes/decrement")
	public ResponseEntity<String> decrementLikes(@RequestParam long id) {
		codeService.decrementLikes(id);
		return ResponseEntity.ok("Likes count incremented");
	}

}