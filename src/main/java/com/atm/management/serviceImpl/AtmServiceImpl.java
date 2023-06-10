package com.atm.management.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.management.dto.AccountDto;
import com.atm.management.dto.AtmRequestDto;
import com.atm.management.dto.AtmWithDrawDto;
import com.atm.management.dto.ResponseVo;
import com.atm.management.model.AccountEntity;
import com.atm.management.repository.MoneyRepository;
import com.atm.management.service.AtmService;

@Service
public class AtmServiceImpl implements AtmService{

	@Autowired
	private MoneyRepository moneyRepository;
	
	
	public ResponseVo createCustomer(AccountDto account) {
	
		
		AccountEntity accountNumberExistOrNot=moneyRepository.findByAccountNumber(account.getAccountNumber());
		
		if(accountNumberExistOrNot!=null) {
			return new ResponseVo(null,"Failed AccountNumber Already Exist!!");
		}
		else {
			
			accountNumberExistOrNot=new AccountEntity();
			
			accountNumberExistOrNot.setAccountBalance(account.getDepositAmount());
			accountNumberExistOrNot.setAccountName(account.getAccountName());
			accountNumberExistOrNot.setAccountNumber(account.getAccountNumber());
			AccountEntity saved=moneyRepository.save(accountNumberExistOrNot);
			
			if(saved!=null) {
				return new ResponseVo("Account Created Successfully",null);
			}
			else {
				return new ResponseVo(null,"Failed to Create new Account");
			}
			
			
		}
	}

	
	public ResponseVo CreateAtmServices(AtmRequestDto atmRequest) {
		
		
		AccountEntity accountNumberExistOrNot=moneyRepository.findByAccountNumber(atmRequest.getAccountNumber());
		
		if(accountNumberExistOrNot==null) {
			return new ResponseVo(null,"Failed AccountNumber not Exist!!");
		}
		AccountEntity cardNumberExistOrNot=moneyRepository.findByAtmCardNumber(atmRequest.getAtmCardNumber());
		if(cardNumberExistOrNot!=null) {
			return new ResponseVo(null,"Failed Atm Card Number Already Exist!!");
		}
		else {
			accountNumberExistOrNot.setAtmCardNumber(atmRequest.getAtmCardNumber());
			accountNumberExistOrNot.setPassword(atmRequest.getPassword());
			moneyRepository.save(accountNumberExistOrNot);
			return new ResponseVo("Atm services Created Successfully",null);
		}
		
	}

	
	public ResponseVo withDrawMoney(AtmWithDrawDto withDraw) {
		
		AccountEntity cardNumberExistOrNot=moneyRepository.findByAtmCardNumber(withDraw.getAtmCardNumber());
		if(cardNumberExistOrNot==null) {
			return new ResponseVo(null,"Failed Atm Card Number not Exist!!");
		}
		if(cardNumberExistOrNot.getPassword().equals(withDraw.getPassword())) {
			
			if(withDraw.getWithDrawammount()>cardNumberExistOrNot.getAccountBalance()) {
				return new ResponseVo(null,"Insufficient Balance!!  "+ "Current Balance= " + cardNumberExistOrNot.getAccountBalance());
			}
			if(withDraw.getWithDrawammount()%100==0) {
				
				int currentBalance=cardNumberExistOrNot.getAccountBalance();
				
				cardNumberExistOrNot.setAccountBalance(currentBalance-withDraw.getWithDrawammount());
				
				cardNumberExistOrNot.setWithDrawammount(withDraw.getWithDrawammount());
				
				cardNumberExistOrNot.setMoneyWithDrawDate(new Date());
				
				moneyRepository.save(cardNumberExistOrNot);
				
				return new ResponseVo("Money with draw Successfully!! " +withDraw.getWithDrawammount() ,null);
				
			}
			else {
				return new ResponseVo(null,"Invalid Money!!");
			}
			
			
		}else {
			return new ResponseVo(null,"Invalid PIN!!");
		}
		
	}

	
	
	

}
