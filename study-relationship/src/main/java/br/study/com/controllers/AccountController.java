package br.study.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.study.com.dtos.AccountStockResponseDto;
import br.study.com.dtos.AssociateAccountDto;
import br.study.com.dtos.CreateAccountDto;
import br.study.com.services.AccountService;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
	@Autowired
	private AccountService service;
	
	@PostMapping("/{id}/stocks")
	public ResponseEntity<AssociateAccountDto>associateStock(@PathVariable("id") Long id, @RequestBody AssociateAccountDto data){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.associateAccount(id, data));
	}
	@GetMapping("/{id}/stocks")
	public ResponseEntity<List<AccountStockResponseDto>>listStock(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.listStock(id));
	}
	

}
