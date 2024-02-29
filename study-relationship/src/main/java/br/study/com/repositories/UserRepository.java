package br.study.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.study.com.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
