package com.zensar.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.beans.BiddingModel;
import com.zensar.beans.ProductDetails;
import com.zensar.beans.UserDetails;
import com.zensar.model.BidRequest;
import com.zensar.service.BiddingModelServiceImpl;
import com.zensar.service.CustomUserDetailService;

@RestController
@RequestMapping("/bid")
@CrossOrigin(origins = "http://localhost:4200")
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
	public BiddingModel addNewBidModule(@RequestBody BidRequest request) {
		BiddingModel model = new BiddingModel();
		model.setProductId(request.getProductId());
		model.setBidAmount(request.getBidAmount());
		BiddingModel biddingModel = service.addBidData(model, loggedInUser);
		
		return biddingModel;
	}
	
	@GetMapping("/get/{id}")
	public BiddingModel getBidData(@RequestParam("id") int id ) {
		BiddingModel model = service.getBidData(id);
		return model;
	}
	
	@GetMapping("/getMyBiddedProduct")
	public List<ProductDetails> getAllBiddedProductOfLoggedInUser(){
		return service.getLoggedInBuyerProducts(this.loggedInUser.getUserId());
	}
	
}
