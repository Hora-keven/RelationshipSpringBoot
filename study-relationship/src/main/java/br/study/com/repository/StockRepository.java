package br.study.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.study.com.models.Stock;
import br.study.com.models.User;

public interface StockRepository extends JpaRepository<Stock, String> {

}
