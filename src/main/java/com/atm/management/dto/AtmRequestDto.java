package com.atm.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
public class AtmRequestDto {
	
	
	private String accountNumber;
	
	private String atmCardNumber;
	
	private String password;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAtmCardNumber() {
		return atmCardNumber;
	}

	public void setAtmCardNumber(String atmCardNumber) {
		this.atmCardNumber = atmCardNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
