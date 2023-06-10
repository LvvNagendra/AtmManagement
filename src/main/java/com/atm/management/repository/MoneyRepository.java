package com.atm.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.management.dto.AccountDto;
import com.atm.management.dto.AtmWithDrawDto;
import com.atm.management.model.AccountEntity;

@Repository
public interface MoneyRepository extends JpaRepository<AccountEntity, Long> {

	AccountEntity findByAccountNumber(String accountNumber);
	
	AccountEntity findByAtmCardNumber(String cardNumber);

	Object save(AtmWithDrawDto atmWithDraw);
	Object save(AccountDto account);
}
