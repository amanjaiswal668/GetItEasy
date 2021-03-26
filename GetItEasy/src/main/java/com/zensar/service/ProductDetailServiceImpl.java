package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.ProductDetails;
import com.zensar.repository.ProductRepository;

@Service
public class ProductDetailServiceImpl {

	@Autowired
	private ProductRepository repository;

	public ProductDetails createProduct(ProductDetails productDetails) {
		return repository.save(productDetails);
	}

	public ProductDetails getProduct(int id) {
		return repository.findById(id).get();
	}

	public List<ProductDetails> getProductByName(String name) {
		return repository.findProductDetailsByproductName(name);
	}

	public ProductDetails updateProduct(ProductDetails product) {
		return repository.save(product);	
	}
	
	public List<ProductDetails> getAllProductsOfUser(int userId){
		return repository.findAllProductBySellerId(userId);
	}

	public List<ProductDetails> getAllProducts() {
		return repository.findAll();
	}
	
}
