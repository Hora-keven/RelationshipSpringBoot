package br.study.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.study.com.dtos.AccountStockResponseDto;
import br.study.com.dtos.AssociateAccountDto;
import br.study.com.exceptions.AccountException;
import br.study.com.exceptions.StockException;
import br.study.com.models.AccountStock;
import br.study.com.models.AccountStockId;
import br.study.com.repository.AccountRepository;
import br.study.com.repository.AccountStockRepository;
import br.study.com.repository.StockRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private AccountStockRepository accountStockRepository;
	
	public AssociateAccountDto associateAccount(Long id, AssociateAccountDto data) {
		var account = accountRepository.findById(id);
		if(account.isEmpty()) throw new AccountException("Account not found!");
		
		var stock = stockRepository.findById(data.stockId());
		if(stock.isEmpty()) throw new StockException("Stock not found!");
		
		var bothId = new AccountStockId(account.get().getId(), stock.get().getId());
		var entity = new AccountStock(bothId, account.get(), stock.get(), data.quantity());
		accountStockRepository.save(entity);
		return data;
		
	}

	public List<AccountStockResponseDto> listStock(Long id) {
		var account = accountRepository.findById(id);
		if(account.isEmpty()) throw new AccountException("Account not found!");
		
		return account.get().getAccountStock().stream().map(as -> new AccountStockResponseDto(as.getStock().getId(),as.getQuantity(), 0.0)).toList();
		
				
	}
}
