package com.zensar.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.beans.BiddingModel;
import com.zensar.beans.UserDetails;
import com.zensar.service.BiddingModelServiceImpl;
import com.zensar.service.CustomUserDetailService;
import com.zensar.service.ProductDetailServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@Autowired
	private CustomUserDetailService userService;
	
	@Autowired
	private ProductDetailServiceImpl productService;
	
	@Autowired
	private BiddingModelServiceImpl biddingService;
	
	@RequestMapping("/getAllUsers")
	public List<UserDetails> getAllUsers(){
		return userService.getAllUsers();
	}

	@RequestMapping("/getUser/{username}")
	public com.zensar.beans.UserDetails getUserByUserName(@PathVariable("username") String username){
		return userService.loadUserByUsername(username);
	}
	
	@RequestMapping("/getUser/{userId}")
	public com.zensar.beans.UserDetails getUserByUserId(@PathVariable("userId") int userId){
		return userService.getUserByUserId(userId);
	}
	
	@RequestMapping("/getBidHistory/{productId}")
	public List<BiddingModel> getHistoryOfProduct(@PathVariable("productId") int productId){
		return biddingService.getAllBidDataOfProduct(productId);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId") int userId){
		
		 userService.deleteUser(userId);
	}

	@GetMapping("/allBidList")
	public List<BiddingModel> getBidList(){
		return biddingService.getAllBidList();
	}
	
}
