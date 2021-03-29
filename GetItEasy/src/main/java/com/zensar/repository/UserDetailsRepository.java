package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.beans.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	

	@Query(value = "FROM UserDetails where userName=:userName")
	UserDetails finduserByuserName(@Param("userName") String userName);
	
	@Query("From UserDetails where userId=:userId")
	UserDetails UserDetailsByuserId(@Param("userId") int userId);
	
}
