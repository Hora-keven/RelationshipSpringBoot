package br.study.com.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class AccountStockId {
	
	private Long accountId;
	private String stockId;
	
	
	public AccountStockId() {
		super();
	}
	public AccountStockId(Long accountId, String stockId) {
		super();
		this.accountId = accountId;
		this.stockId = stockId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
}
