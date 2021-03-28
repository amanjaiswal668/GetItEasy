package com.zensar.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.beans.ProductDetails;
import com.zensar.beans.UserDetails;
import com.zensar.service.CustomUserDetailService;
import com.zensar.service.ProductDetailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
@RestController
public class ProductDetailController {

	private UserDetails loggedInUser;

	@Autowired
	private CustomUserDetailService userService;

	@Autowired
	private ProductDetailServiceImpl service;

	public ProductDetailController() {

	};

	@PostMapping("/createProduct")
	public ResponseEntity<ProductDetails> createProduct(@RequestBody ProductDetails productDetails) {
		ProductDetails newProduct = service.createProduct(productDetails);
		return new ResponseEntity<ProductDetails>(newProduct, HttpStatus.CREATED);
	}

	// test method
	@GetMapping("/getProduct")
	public ResponseEntity<ProductDetails> getProductById() {
		ProductDetails product = service.getProduct(1);
		ResponseEntity<ProductDetails> responseEntity = new ResponseEntity<ProductDetails>(product, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductDetails> getProductById(@PathVariable(value = "id") int id) {
		ProductDetails product = service.getProduct(id);
		ResponseEntity<ProductDetails> responseEntity = new ResponseEntity<ProductDetails>(product, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/getProductByName/{name}")
	public ResponseEntity<List<ProductDetails>> getProductByName(@PathVariable(value = "name") String name) {
		List<ProductDetails> product = service.getProductByName(name);
		return new ResponseEntity<List<ProductDetails>>(product, HttpStatus.OK);

	}

	@GetMapping("/getAllProducts")
	public List<ProductDetails> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/getMyProducts")
	public List<ProductDetails> getAllProductsOfLoggedInUser() {
		return service.getAllProductsOfUser(this.loggedInUser.getUserId());

	}

	@PostMapping("/updateProduct")
	public ResponseEntity<ProductDetails> updateProduct(@RequestBody ProductDetails productDetails) {
		ProductDetails newProduct = service.updateProduct(productDetails);
		return new ResponseEntity<ProductDetails>(newProduct, HttpStatus.CREATED);
	}

	@ModelAttribute
	public void currentUserLoggedIn() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		this.loggedInUser = userService.loadUserByUsername(name);

	}

}
