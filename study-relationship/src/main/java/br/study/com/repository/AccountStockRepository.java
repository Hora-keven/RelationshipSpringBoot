package br.study.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.study.com.models.AccountStock;
import br.study.com.models.AccountStockId;
import br.study.com.models.User;

public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {

}
