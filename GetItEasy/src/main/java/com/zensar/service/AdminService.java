package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.BiddingModel;

@Service
public class AdminService {

	@Autowired
	private CustomUserDetailService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BiddingModelServiceImpl biddingService;

	public void sendEmail(int bidId) {
		BiddingModel bidData = biddingService.getBidData(bidId);
		String buyerEmail = userService.getUserByUserId(bidData.getSellerId()).getEmail();
		String sellerEmail = userService.getUserByUserId(bidData.getUserId()).getEmail();
		String message = "This is to inform you to close the deal as your product bidding is going to close!!!";
		String subject = "GetItEasy : EmailService";
		String[] to = {buyerEmail,sellerEmail};
		emailService.sendEmail(subject,message,to);
		System.out.println("Mail Method Finished!!!");
	}
	
	
}
