package br.study.com.models;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.study.com.dtos.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	@CreationTimestamp
	private Instant creationTimestamp;
	@UpdateTimestamp
	private Instant updateTimestamp;
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@OneToMany(mappedBy = "user")
	private List<Account> accounts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Instant getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(Instant creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public Instant getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Instant updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public User(String username, String email, String password, Instant creationTimestamp, Instant updateTimestamp) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		
	}
	public User() {
		super();
	}
	public User(UserDto data) {
		this.username = data.username();
		this.email = data.email();
		this.password = data.password();
	}

}
