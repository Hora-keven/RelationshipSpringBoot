package br.study.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.study.com.dtos.AccountResponseDto;
import br.study.com.dtos.CreateAccountDto;
import br.study.com.dtos.UserDto;
import br.study.com.dtos.UserResponseDto;
import br.study.com.exceptions.UserException;
import br.study.com.models.Account;
import br.study.com.models.BillingAddress;
import br.study.com.models.User;
import br.study.com.repository.AccountRepository;
import br.study.com.repository.BillingAddressRepository;
import br.study.com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	

	public UserResponseDto create(UserDto data) {
		var entity = new User(data);
		userRepository.save(entity);
		
		return new UserResponseDto(entity);
	}
	public UserResponseDto findById(Long id) {
		var entity = userRepository.findById(id);
		if (entity.isEmpty()) throw new UserException("user not found!");
		return new UserResponseDto(entity.get());
		
	}
	public UserResponseDto update(Long id, UserDto data){
		var entity = userRepository.findById(id);
		if (entity.isEmpty()) throw new UserException("user not found!");
		
		var user = entity.get();
		if(data.email() != null) {
			user.setEmail(data.email());
		}
		if(data.password() != null) user.setPassword(data.password());
		if (data.username() != null) user.setUsername(data.username());
	
		userRepository.save(user);
		return new UserResponseDto(user);
	}
	public void delete(Long id){
		userRepository.deleteById(id);
	}
	public List<UserResponseDto> findAll(){
		var entities = userRepository.findAll();
		List<UserResponseDto> users = new ArrayList<>();
		for (User user : entities) {
			var userDto = new UserResponseDto(user);
			users.add(userDto);
		}
		return users;
		
	}
	public CreateAccountDto createAccount(Long id, CreateAccountDto data){
		var user = userRepository.findById(id);
		if (user.isEmpty()) throw new UserException("user not found!");

		var account = new Account(id, data.description(), user.get(), null, new ArrayList<>());
		var accountCreated = accountRepository.save(account);

		var billingAddress = new BillingAddress(accountCreated.getId(), account, data.street(), data.number());

		billingAddressRepository.save(billingAddress);
		return data;
	}
	public List<AccountResponseDto> listAccounts(Long id){
		var user = userRepository.findById(id);
		if (user.isEmpty()) throw new UserException("user not found!");
		return user.get().getAccounts().stream().map(ac -> new AccountResponseDto(ac.getId(), ac.getDescription())).toList();
		

	}
}
