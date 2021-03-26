
package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.beans.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Integer> {
	
	public List<ProductDetails> findProductDetailsByproductName(String name);

	public List<ProductDetails> findAllProductBySellerId(int sellerId);

}