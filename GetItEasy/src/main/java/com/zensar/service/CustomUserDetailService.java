package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.repository.UserDetailsRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserDetailsRepository repository;
	
	@Override
	public  com.zensar.beans.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 com.zensar.beans.UserDetails finduserByuserName = repository.finduserByuserName(username);
		 return finduserByuserName;
	}
	
	public UserDetails createUser(com.zensar.beans.UserDetails user) {
		return repository.save(user);
	}

}
