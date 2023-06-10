package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.atm.management.dto.AccountDto;
import com.atm.management.dto.AtmRequestDto;
import com.atm.management.dto.AtmWithDrawDto;
import com.atm.management.model.AccountEntity;
import com.atm.management.repository.MoneyRepository;
import com.atm.management.service.AtmService;

@SpringBootTest
public class TestAtm {
	
	@Autowired
	private AtmService atmService;
	@MockBean
	private MoneyRepository moneyRepository;
	
	
	private AccountDto account;
	
	private AtmRequestDto atmRequest;
	
	
	private AtmWithDrawDto atmWithDraw;
	
	private AccountEntity entity;
	
	@BeforeEach
	public void SetUp() {
//		entity=new AccountEntity(1,"nani","23455","3455","123",1000,500,"2023-01-02");
		
		account=new AccountDto("nani","23455",1000);
		atmRequest=new AtmRequestDto("23455","3455","123");
		atmWithDraw=new AtmWithDrawDto(2000,"3455","123");
	}
	@AfterEach
	public void tearDown() { 
		System.out.println("@AfterEach - runAfterTestMethod");
	}
	@Test
	 public void saveWithdraw()
	 {
			when(moneyRepository.save(atmWithDraw)).thenReturn(atmWithDraw);
			
			assertNotEquals(atmWithDraw,atmService.withDrawMoney(atmWithDraw));
			System.out.println("save---"+atmWithDraw);
	
			if(atmWithDraw.getWithDrawammount()%100==0) {
				System.out.println("invalidbalance");
			}
				else if (entity.getWithDrawammount()>=entity.getAccountBalance()){
					System.out.println("insufficint balance");
					
				
			}
				else {
					System.out.println("money withdraw sucess");
				}
	 }
	
	
	public void accountSave() {
		when(moneyRepository.save(account)).thenReturn(account);
		assertEquals(account, atmService.createCustomer(account));
		System.out.println(account);
		
	}
	

	@Test
	public void saveAccountDtoTest() {
		when(moneyRepository.save(atmWithDraw)).thenReturn(account);
		assertNotEquals(account, atmService.createCustomer(account));
		
		System.out.println("save--"+account);
		
		

		
		
	}
	
	
	@Test
	public void saveAtmRequestDtoTest() {
		
		when(moneyRepository.save(atmWithDraw)).thenReturn(account);
		
		assertNotEquals(atmRequest, atmService.CreateAtmServices(atmRequest));

		System.out.println("save--"+atmRequest);
		
	}}

//	@Test
//	public void saveWithdrawTest() {
//		when(moneyRepository.save(account)).thenReturn(account);
//		assertNotEquals(atmWithDraw, atmService.withDrawMoney(atmWithDraw));
//
//		System.out.println("save--"+atmWithDraw);
//	}
//	
//	"accountName":"nagendra",
//    "accountNumber":"123344321",
//    "depositAmount":10000
//	
//	private AccountEntity model;
//	
//	@BeforeEach
//	public void setUp() {
//		model=new AccountEntity(1,700,"nani",1234,32344,"2222/08/7","1234",500 );
//	}
//	
//	public void saveUserTest() {
//		when(repo.save(model)).thenReturn(model);
//
//		assertEquals(model, atmservice.CreateAtmServices(model));
//		System.out.println("save---" + model);
//	}

	
	
	


