package com.zensar.controlller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.helper.JwtUtil;
import com.zensar.model.LoginRequest;
import com.zensar.model.LoginResponse;
import com.zensar.service.CustomUserDetailService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
@RestController
public class AuthController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> generateToken(@RequestBody LoginRequest request) throws Exception {
		System.out.println(request);
		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (UsernameNotFoundException | BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}

		com.zensar.beans.UserDetails userDetails = this.service.loadUserByUsername(request.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		String type = userDetails.getType();
		String name = userDetails.getFirstName();
		System.out.println("JWT ===>" + token);

		return new ResponseEntity<LoginResponse>(new LoginResponse(token,type,name), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/signup")
	@Transactional
	public ResponseEntity<?> createUser(@RequestBody com.zensar.beans.UserDetails request) throws Exception {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		UserDetails newUser = service.createUser(request);
		if (newUser == null) {
			throw new Exception("User not registered");
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}

}
