package com.zensar.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zensar.beans.ProductDetails;
import com.zensar.helper.FileUploaderHelper;
import com.zensar.model.AddProductRequest;
import com.zensar.repository.ProductRepository;

@Service
public class ProductDetailServiceImpl {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private FileUploaderHelper uploader;
	
	private String UPLOAD_PATH = "./assets/images/";

	public ProductDetails createProduct(ProductDetails productDetails , int userId) {
		productDetails.setSellerId(userId);
		productDetails.setClosingDate(LocalDateTime.now().plusHours(24));
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

	public void deleteProduct(int productId) {
		
		repository.deleteById(productId);
		
	}

	public String uploadImage(MultipartFile file, int productId) {
		String message = "File not uploaded";
		ProductDetails productDetails = repository.findById(productId).get();
		productDetails.setUrl(UPLOAD_PATH+"product"+productId+file.getOriginalFilename());
		repository.save(productDetails);
		boolean uploadFile = uploader.uploadFile(file, productId);
		if(uploadFile) {
			message = "File uploaded";
		}
		return message;
	}
	
}
