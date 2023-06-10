package com.atm.management.service;



import com.atm.management.dto.AccountDto;
import com.atm.management.dto.AtmRequestDto;
import com.atm.management.dto.AtmWithDrawDto;
import com.atm.management.dto.ResponseVo;


public interface AtmService {
	
	
	ResponseVo createCustomer(AccountDto account);

	ResponseVo CreateAtmServices(AtmRequestDto atmRequest);

	ResponseVo withDrawMoney(AtmWithDrawDto withDraw);

	
	

}
