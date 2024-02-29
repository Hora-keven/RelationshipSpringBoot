package br.study.com.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKey;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_billing_address")
public class BillingAddress {
	@Id
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private Account account;
	
	private String street;
	public BillingAddress() {
		super();
	}
	public BillingAddress(Long id, String street, String number) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	private String number;

}
