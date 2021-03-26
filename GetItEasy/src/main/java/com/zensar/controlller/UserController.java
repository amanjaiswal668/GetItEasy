package com.zensar.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.beans.UserDetails;
import com.zensar.service.CustomUserDetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@RestController
public class UserController {
	private UserDetails loggedInUser;

	@Autowired
	private CustomUserDetailService userService;
	
	@GetMapping("/getData")
	public UserDetails getUserDetailsOfLoggedInUser() {
		UserDetails userdata = this.loggedInUser;
		return userdata;
	}
	
	@PostMapping("/updateData")
	public UserDetails updateUserDetailsOfLoggedInUser(@RequestBody UserDetails userDetails) throws Exception {
		if(userDetails.getUserId()==this.loggedInUser.getUserId()) {
			return userService.updateUser(userDetails);
		}
		else {
			throw new Exception("Product doesn't exist!!!");
		}
		
	}
	
	@ModelAttribute
	public void currentUserLoggedIn() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		this.loggedInUser = userService.loadUserByUsername(name);
	}
}
