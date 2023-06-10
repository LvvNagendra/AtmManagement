package com.atm.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_money")
public class AccountEntity {

	public AccountEntity(int id2, String accountName2, String accountNumber2, String atmCardNumber2, String password2,
			int accountBalance2, int withDrawammount2, String string) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String accountName;

	private String accountNumber;
	
	private String atmCardNumber;
	
	private String password;

	private int accountBalance;

	private int withDrawammount;

	private Date moneyWithDrawDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

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

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getWithDrawammount() {
		return withDrawammount;
	}

	public void setWithDrawammount(int withDrawammount) {
		this.withDrawammount = withDrawammount;
	}

	public Date getMoneyWithDrawDate() {
		return moneyWithDrawDate;
	}

	public void setMoneyWithDrawDate(Date moneyWithDrawDate) {
		this.moneyWithDrawDate = moneyWithDrawDate;
	}



}
