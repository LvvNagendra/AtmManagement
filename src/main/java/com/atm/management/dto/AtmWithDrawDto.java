package com.atm.management.dto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
;


@AllArgsConstructor
@NoArgsConstructor
public class AtmWithDrawDto {
	
	private int withDrawammount;
	
	private String atmCardNumber;
	
	private String password;

	public int getWithDrawammount() {
		return withDrawammount;
	}

	public void setWithDrawammount(int withDrawammount) {
		this.withDrawammount = withDrawammount;
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
