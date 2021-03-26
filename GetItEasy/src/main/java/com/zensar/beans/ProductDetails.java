
package com.zensar.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {

	private String productName;

	private String productType;

	private String productDescription;

	private int initialBiddingAmount;
	
	private int lastBiddedAmount;

	private LocalDateTime closingDate;
	
	private String url;
	
	private int sellerId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	public ProductDetails() {
		super();
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

	public int getLastBiddedAmount() {
		return lastBiddedAmount;
	}

	public void setLastBiddedAmount(int lastBiddedAmount) {
		this.lastBiddedAmount = lastBiddedAmount;
	}

	public LocalDateTime getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDateTime closingDate) {
		this.closingDate = closingDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	@Override
	public String toString() {
		return "ProductDetails [productName=" + productName + ", productType=" + productType + ", productDescription="
				+ productDescription + ", initialBiddingAmount=" + initialBiddingAmount + ", lastBiddedAmount="
				+ lastBiddedAmount + ", closingDate=" + closingDate + ", url=" + url + ", productId=" + productId + "]";
	}
	
}
