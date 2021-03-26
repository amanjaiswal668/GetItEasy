package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.BiddingModel;

public interface BiddingModelRepository extends JpaRepository<BiddingModel, Integer> {
	
	
	public BiddingModel findFirstByProductIdOrderByBidAmountDesc(int productId);
	
	public List<BiddingModel> findByuserId(int userId);

}
