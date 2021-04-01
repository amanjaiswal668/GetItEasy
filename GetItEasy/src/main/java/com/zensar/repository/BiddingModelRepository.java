package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.beans.BiddingModel;

public interface BiddingModelRepository extends JpaRepository<BiddingModel, Integer> {
	
	public List<BiddingModel> findByUserId(int userId);
	
	public BiddingModel findFirstByProductIdOrderByBidAmountDesc(int productId);
	
	public List<BiddingModel> findAllByProductId(int productId);

}
