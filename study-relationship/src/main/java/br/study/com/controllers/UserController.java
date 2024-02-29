package br.study.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.study.com.dtos.UserDto;
import br.study.com.dtos.UserResponseDto;
import br.study.com.models.User;
import br.study.com.services.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserResponseDto> create(@RequestBody UserDto data){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(data));
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> findById(@PathVariable(name = "id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDto> update(@PathVariable(name = "id")Long id, @RequestBody UserDto data){
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, data));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<UserResponseDto> update(@PathVariable(name = "id")Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping
	public ResponseEntity<List<UserResponseDto>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}
