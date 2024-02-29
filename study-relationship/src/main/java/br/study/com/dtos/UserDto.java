package br.study.com.dtos;

import java.time.Instant;

import br.study.com.models.User;

public record UserDto(Long id, String username, String password, String email, Instant creationTime, Instant updateTime) {
	public UserDto(User data) {
		this(data.getId(), data.getUsername(), data.getPassword(), data.getEmail(), data.getCreationTimestamp(), data.getUpdateTimestamp());;
	}
}
