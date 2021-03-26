package com.zensar.controlller;

import java.util.Map;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.beans.UserDetails;
import com.zensar.helper.JwtUtil;
import com.zensar.service.CustomUserDetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test")
@RestController
public class Home {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailService service;

	@RequestMapping("/welcome")
	public String welcome(@RequestHeader Map<String, String> headers) {
		String jwttoken = headers.get("authorization");
		System.out.println(jwttoken);

		String token = jwttoken.substring(7);
		System.out.println("Token ==> " + token);
		String extractUsername = jwtUtil.extractUsername(token);
		System.out.println("username ==> " + extractUsername);

		UserDetails userDetails = service.loadUserByUsername(extractUsername);
		System.out.println(userDetails);

		String text = "this is a private page";
		text += " this page is not allowed to unauthenticated user " + userDetails.getEmail();
		return text;
	}

	@RequestMapping("/google")
	public String google() {
		System.out.println("Google method on signin");
		return "Google";
	}

}
