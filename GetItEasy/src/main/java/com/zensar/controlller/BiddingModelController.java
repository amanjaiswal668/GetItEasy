package com.zensar.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.beans.UserDetails;
import com.zensar.model.BiddingModel;
import com.zensar.service.BiddingModelServiceImpl;
import com.zensar.service.CustomUserDetailService;

@RestController
@RequestMapping("/bid")

public class BiddingModelController {
	
	private UserDetails loggedInUser;

	@Autowired
	private CustomUserDetailService userService;
	
	@Autowired
	private BiddingModelServiceImpl service;
	
	@ModelAttribute
	public void currentUserLoggedIn() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		this.loggedInUser = userService.loadUserByUsername(name);
		
	}
	
	@PostMapping("/add")
	public BiddingModel addNewBidModule(@RequestBody BiddingModel model,UserDetails loggedInUser) {
		service.addBidData(model,loggedInUser);
		return model;
	}
	
}
