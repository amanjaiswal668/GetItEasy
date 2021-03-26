package com.zensar.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.ProductDetails;
import com.zensar.beans.UserDetails;
import com.zensar.model.BiddingModel;
import com.zensar.repository.BiddingModelRepository;
@Service
public class BiddingModelServiceImpl {
	
	@Autowired
	private ProductDetailServiceImpl productService;
	
	@Autowired
	private BiddingModelRepository repository;
	
	public List<BiddingModel> getAllBidDataOfUser(int userId){
		return repository.findByuserId(userId);
	}

	public BiddingModel addBidData(BiddingModel model, UserDetails loggedInUser) {
		model.setTimeBidded(LocalDateTime.now());
		model.setUserId(loggedInUser.getUserId());
		ProductDetails product = productService.getProduct(model.getProductId());
		product.setLastBiddedAmount(model.getBidAmount());
		productService.updateProduct(product);
		return repository.save(model);
	}
	
	public BiddingModel getBidData(int id) {
		return repository.getOne(id);
	}
	
	public void deleteBidData(int id,UserDetails loggedInUser) throws Exception {
		BiddingModel model = repository.getOne(id);
		int productId = model.getProductId();
		int bidAmount = repository.findFirstByProductIdOrderByBidAmountDesc(productId).getBidAmount();
		ProductDetails product = productService.getProduct(productId);
		product.setLastBiddedAmount(bidAmount);
		productService.updateProduct(product);
		if(model.getUserId()==loggedInUser.getUserId()) {
			repository.deleteById(id);
			
		}else {
			throw new Exception("User for this bid is not matching with the records!!!");
		}
	}

	
}
