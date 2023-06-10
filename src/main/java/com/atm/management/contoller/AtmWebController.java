package com.atm.management.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.atm.management.dto.AccountDto;
import com.atm.management.dto.AtmRequestDto;
import com.atm.management.dto.AtmWithDrawDto;
import com.atm.management.model.AccountEntity;
import com.atm.management.repository.MoneyRepository;
import com.atm.management.serviceImpl.AtmServiceImpl;
@Controller
public class AtmWebController {
	
	
	@Autowired
	private AtmServiceImpl atmService;
	@Autowired
	private MoneyRepository repo;
	@GetMapping("/request")
	public String bankRequst()
	{
		return "index";
	}
	
	
	@GetMapping("/addUser")
	public String addEmpForm()
	{
		return "user_register";
	}
	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute AccountDto request, HttpSession session)
	{
		
		
		AccountEntity model=repo.findByAccountNumber(request.getAccountNumber());
		try {
		if(model!=null) {
			session.setAttribute("msg", "User Already existed");
			return "redirect:/";
			
		}else {
		
			atmService.createCustomer(request);
		session.setAttribute("msg", "User Added Succesfully");
		
		return "redirect:/";
		}} catch (Exception e) {
			// An error occurred while processing hiring request
			
			session.setAttribute("msg", "User notAdded Succesfully");
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/AtmRequest")
	public String addEmpForms()
	{
		return "atm_request";
	}
	
	
	@PostMapping("/AtmRequest")
	public String atmRegister(@ModelAttribute AtmRequestDto request, HttpSession session)
	{
		
		
		AccountEntity model=repo.findByAtmCardNumber(request.getAtmCardNumber());
		try {
		if(model!=null) {
			session.setAttribute("msg", "User Already existed");
			return "redirect:/";
			
		}else {
		
			atmService.CreateAtmServices(request);
		session.setAttribute("msg", "User Added Succesfully");
		
		return "redirect:/";
		}} catch (Exception e) {
			// An error occurred while processing hiring request
			
			session.setAttribute("msg", "User notAdded Succesfully");
			return "redirect:/";
		}
	}
	
	
	
	@GetMapping("/witdrawAmount")
	public String addEmpFormss()
	{
		return "withdraw_request";
	}
	
	
	@PostMapping("/witdrawAmount")
	public String atmRegisterss(@ModelAttribute AtmWithDrawDto request, HttpSession session)
	{
		
		
		AccountEntity model=repo.findByAtmCardNumber(request.getAtmCardNumber());
		try {
		if(model==null) {
			session.setAttribute("msg", "User not existed");
			return "redirect:/";
			
		}else {
		
			atmService.withDrawMoney(request);
		session.setAttribute("msg", "wiithdraw amount Succesfully");
		
		return "redirect:/";
		}} catch (Exception e) {
			// An error occurred while processing hiring request
			
			session.setAttribute("msg", "User notAdded Succesfully");
			return "redirect:/";
		}
	}
	

}
