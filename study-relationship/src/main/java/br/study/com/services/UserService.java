package br.study.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.study.com.dtos.UserDto;
import br.study.com.dtos.UserResponseDto;
import br.study.com.exceptions.UserException;
import br.study.com.models.User;
import br.study.com.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserResponseDto create(UserDto data) {
		var entity = new User(data);
		repository.save(entity);
		
		return new UserResponseDto(entity);
	}
	public UserResponseDto findById(Long id) {
		var entity = repository.findById(id);
		if (entity.isEmpty()) throw new UserException("user not found!");
		return new UserResponseDto(entity.get());
		
	}
	public UserResponseDto update(Long id, UserDto data){
		var entity = repository.findById(id);
		if (entity.isEmpty()) throw new UserException("user not found!");
		
		var user = entity.get();
		if(data.email() != null) {
			user.setEmail(data.email());
		}
		if(data.password() != null) user.setPassword(data.password());
		if (data.username() != null) user.setUsername(data.username());
	
		repository.save(user);
		return new UserResponseDto(user);
	}
	public void delete(Long id){
		repository.deleteById(id);
	}
	public List<UserResponseDto> findAll(){
		var entities = repository.findAll();
		List<UserResponseDto> users = new ArrayList<>();
		for (User user : entities) {
			var userDto = new UserResponseDto(user);
			users.add(userDto);
		}
		return users;
		
	}
}
