package com.zensar.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BiddingModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bidId;
	
	private int productId;

	private int userId;
	
	private int sellerId;
	
	private LocalDateTime timeBidded;
	
	private int bidAmount;
	
	

	public BiddingModel() {
		super();
	}

	public BiddingModel(int bidId, int productId, int userId, int sellerId, LocalDateTime timeBidded, int bidAmount) {
		super();
		this.bidId = bidId;
		this.productId = productId;
		this.userId = userId;
		this.sellerId = sellerId;
		this.timeBidded = timeBidded;
		this.bidAmount = bidAmount;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public LocalDateTime getTimeBidded() {
		return timeBidded;
	}

	public void setTimeBidded(LocalDateTime timeBidded) {
		this.timeBidded = timeBidded;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Override
	public String toString() {
		return "BiddingModel [bidId=" + bidId + ", productId=" + productId + ", userId=" + userId + ", sellerId="
				+ sellerId + ", timeBidded=" + timeBidded + ", bidAmount=" + bidAmount + "]";
	}
	

	
}
