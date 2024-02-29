package br.study.com.dtos;

import java.time.Instant;

import br.study.com.models.User;

public record UserResponseDto(Long id, String username, String email, Instant creationTime, Instant updateTime) {
	public UserResponseDto(User data) {
		this(data.getId(), data.getUsername(), data.getEmail(), data.getCreationTimestamp(), data.getUpdateTimestamp());
	}
}
