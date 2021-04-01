package com.zensar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.BiddingModel;
import com.zensar.beans.ProductDetails;
import com.zensar.beans.UserDetails;
import com.zensar.repository.BiddingModelRepository;
import com.zensar.repository.ProductRepository;

@Service
public class BiddingModelServiceImpl {

	@Autowired
	private ProductDetailServiceImpl productService;

	@Autowired
	private BiddingModelRepository bidModelRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<BiddingModel> getAllBidDataOfUser(int userId) {
		return bidModelRepository.findByUserId(userId);
	}

	public BiddingModel addBidData(BiddingModel model, UserDetails loggedInUser) {
		model.setTimeBidded(LocalDateTime.now());
		model.setUserId(loggedInUser.getUserId());
		ProductDetails product = productService.getProduct(model.getProductId());
		product.setLastBiddedAmount(model.getBidAmount());
		model.setSellerId(product.getSellerId());
		productService.updateProduct(product);
		return bidModelRepository.save(model);
	}

	public BiddingModel getBidData(int id) {
		return bidModelRepository.findById(id).get();
	}

	public void deleteBidData(int id, int userId) throws Exception {
		BiddingModel model = bidModelRepository.getOne(id);
		int productId = model.getProductId();
		int bidAmount = bidModelRepository.findFirstByProductIdOrderByBidAmountDesc(productId).getBidAmount();
		ProductDetails product = productService.getProduct(productId);
		product.setLastBiddedAmount(bidAmount);
		productService.updateProduct(product);
		if (model.getUserId() == userId) {
			bidModelRepository.deleteById(id);

		} else {
			throw new Exception("User for this bid is not matching with the records!!!");
		}
	}

	public List<ProductDetails> getLoggedInBuyerProducts(int userId) {
		List<ProductDetails> products = new ArrayList<>();
		List<BiddingModel> bidDataOfUser = bidModelRepository.findByUserId(userId);
	  for (BiddingModel bidData : bidDataOfUser) { ProductDetails productDetails =
	  productRepository.getOne(bidData.getProductId()); ProductDetails cloned = new
	  ProductDetails(productDetails.getProductName(),
	  productDetails.getProductType(), productDetails.getProductDescription(),
	  productDetails.getInitialBiddingAmount(),
	  bidData.getBidAmount(), productDetails.getClosingDate(),
	  productDetails.getUrl(), productDetails.getSellerId(),
	  productDetails.getProductId());
	  
	  products.add(cloned); } System.out.println(products);
	  
	  return products; }
	 

	public List<BiddingModel> getAllBidDataOfProduct(int productId) {
		return bidModelRepository.findAllByProductId(productId);
	}

	public List<BiddingModel> getAllBidList() {

		return bidModelRepository.findAll();
	}

}
