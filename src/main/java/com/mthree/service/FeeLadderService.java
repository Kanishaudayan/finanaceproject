package com.mthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.entity.Exchange;
import com.mthree.entity.FeeLadder;
import com.mthree.entity.Order;
import com.mthree.repository.FeeLadderRepository;

@Service
public class FeeLadderService {

	@Autowired
	private FeeLadderRepository feeLadderRepo;

	public double findFeeForExchange(int exchangeId, Order order) {
		FeeLadder f = feeLadderRepo.getFeeLadder(exchangeId);

		int quantity = order.getStocksToBeTraded();
		if(quantity <= 100 && quantity >0)
			return f.getBelow100();
		else if (quantity <= 500 && quantity >100)
			return f.getBelow500();
		return f.getAbove500();		
	}
}
