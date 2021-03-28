package com.zensar.model;

public class BidRequest {
	
	private int productId;
	
	private int bidAmount;
	
	public BidRequest() {}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

}
