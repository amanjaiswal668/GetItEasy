package com.zensar.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class UserDetails implements Serializable,org.springframework.security.core.userdetails.UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String userName;

	private String password;

	private String email;

	private String lastName;

	private boolean isSeller;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private long contactNumber;

	public UserDetails() {
		super();
	}



	public UserDetails(String firstName, String userName, String password, String email, String lastName,
			boolean isSeller, int userId, long contactNumber) {
		super();
		
		System.out.println("Inside Constructor");
		
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.lastName = lastName;
		this.isSeller = isSeller;
		this.userId = userId;
		this.contactNumber = contactNumber;	
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		
		System.out.println("public void setUsername(String username)");
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean isSeller() {
		return isSeller;
	}

	public void isSeller(boolean isSeller) {
		System.out.println("public void setSeller(boolean isSeller)");
		this.isSeller = isSeller;
	}

	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", username=" + userName + ", password=" + password + ", email="
				+ email + ", lastName=" + lastName + ", userId=" + userId + ", contactNumber=" + contactNumber + "]";
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
