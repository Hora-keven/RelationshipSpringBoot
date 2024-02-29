package br.study.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.study.com.models.BillingAddress;
import br.study.com.models.User;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

}
