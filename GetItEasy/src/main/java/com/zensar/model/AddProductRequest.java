package com.zensar.model;

import org.springframework.web.multipart.MultipartFile;

public class AddProductRequest {

	private String productName;

	private String productType;

	private String productDescription;

	private int initialBiddingAmount;
	
	private MultipartFile image;
	
	public AddProductRequest() {
		
	}

	public AddProductRequest(String productName, String productType, String productDescription,
			int initialBiddingAmount, MultipartFile image) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productDescription = productDescription;
		this.initialBiddingAmount = initialBiddingAmount;
		this.image = image;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getInitialBiddingAmount() {
		return initialBiddingAmount;
	}

	public void setInitialBiddingAmount(int initialBiddingAmount) {
		this.initialBiddingAmount = initialBiddingAmount;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	
}
