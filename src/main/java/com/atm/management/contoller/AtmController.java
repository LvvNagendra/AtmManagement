package com.atm.management.contoller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.management.dto.AccountDto;
import com.atm.management.dto.AtmRequestDto;
import com.atm.management.dto.AtmWithDrawDto;
import com.atm.management.dto.ResponseVo;
import com.atm.management.model.AccountEntity;
import com.atm.management.repository.MoneyRepository;
import com.atm.management.serviceImpl.AtmServiceImpl;


@RestController
@RequestMapping("/api")
public class AtmController {
	public static final Logger Log = LoggerFactory.getLogger(AtmController.class);
	
	@Autowired
	private AtmServiceImpl atmService;
	@Autowired
	private MoneyRepository repo;
	
	
	@PostMapping("/createNewCustomer")
	public ResponseVo createUser(@RequestBody AccountDto account) {
	Log.info("create account sucess"+ account);
		return atmService.createCustomer(account);
		
		
	}
	
	//localhost:8080/api/createNewCustomer
//	{
//		 "accountName":"nagendra",
//		    "accountNumber":"123344321",
//		    "depositAmount":10000
//		}
	
	@PostMapping("/createAtmService")
	public ResponseVo createAtmService(@RequestBody AtmRequestDto atmRequest) {
		Log.info("create atm sucess"+ atmRequest);
		
		Log.error("create atm sucess"+ atmRequest);
		return atmService.CreateAtmServices(atmRequest);
	}
	
	//localhost:8080/api/createAtmService
//	{
//
//		 "accountNumber":"123344321",
//		 "atmCardNumber":"12345432345",
//		 "password":"1232"
//		}
	
	@PostMapping("/withDrawMoney")
	public ResponseVo withDrawMoney(@RequestBody AtmWithDrawDto atmWithDraw) {
		Log.info("create withdaraw sucess"+ atmWithDraw);
		Log.debug("create withdaraw sucess"+ atmWithDraw);
		return atmService.withDrawMoney(atmWithDraw);
		
	}
	
	//localhost:8080/api/withDrawMoney
//	{
//		   "atmCardNumber" :"12345432345",
//		   "password":"1232",
//		   "withDrawammount":100
//		}
	
	@GetMapping("/getByAccno/{accountNumber}")
	public AccountEntity getById(@PathVariable("accountNumber") String accountNumber) {
		return repo.findByAccountNumber(accountNumber);
	}

}
