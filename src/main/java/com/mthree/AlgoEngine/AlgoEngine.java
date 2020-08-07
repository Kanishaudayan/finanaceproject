package com.mthree.AlgoEngine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.mthree.entity.Instrument;
import com.mthree.entity.Order;
import com.mthree.repository.OrderRepository;
import com.mthree.service.FeeLadderService;
@Component
public class AlgoEngine {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private FeeLadderService feeLadderService;
	
	public  int pushToAlgoEngine(int orderId) {
		orderRepository.setOrderStatus(orderId,"inprogress");
		return executeTrade(orderId);
	}
	public int executeTrade(int orderId) {
		Order o= orderRepository.getOne(orderId);
		Instrument insId=o.getInstrumentId();
		boolean flag=internalCrossing(orderId);
		if(!flag) {
			return sor(o);
		}
		return 0;
	}
	public boolean internalCrossing(int orderId) {
		Order o= orderRepository.getOne(orderId);
		Instrument insId=o.getInstrumentId();
		matchBuyersAndSellers(insId.getInstrumentId(),0);
		int left=orderRepository.getOrderQuantityByOrderId(orderId);
		if(left==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public  int sor(Order o) {
		double fee1=feeLadderService.findFeeForExchange(1, o);
		double fee2=feeLadderService.findFeeForExchange(2, o);
		if(fee1<=fee2) {
			return 1;
		}
		else {
			return 2;
		}
	}
	public void matchBuyersAndSellers(int insruId,int orderBooId) {
		double traded=0;
		List<Order> buy=orderRepository.getBuyOrdersFromOrderBook("buy",insruId,orderBooId,"inprogress");
		List<Order> sell=orderRepository.getSellOrdersFromOrderBook("sell",insruId,orderBooId,"inprogress");
		for(int i=0;i<buy.size();i++) {
			for(int j=0;j<sell.size();j++) {
				int temp=0;
				if(buy.get(i).getPrice()>=sell.get(j).getPrice() && buy.get(i).getStocksToBeTraded()>0) {
						temp=buy.get(i).getStocksToBeTraded()-sell.get(j).getStocksToBeTraded();
						traded=traded+updateQuantity(temp,sell,buy,i,j);
				}
			}
		}
		updateStatusOfOrders(buy,sell);
	}
	public static double updateQuantity(int temp,List<Order> sell,List<Order> buy,int i,int j) {
		double traded=0;
		if(temp>0) {
			 traded=temp*sell.get(j).getPrice();
			 buy.get(i).setStocksToBeTraded(temp);
			 sell.get(j).setStocksToBeTraded(0);
		}
		else if(temp<0){
			traded=buy.get(i).getStocksToBeTraded()*sell.get(j).getPrice();
			buy.get(i).setStocksToBeTraded(0);
			sell.get(j).setStocksToBeTraded(-1*temp);
			
		}
		else {
			traded=buy.get(i).getStocksToBeTraded()*sell.get(j).getPrice();
			buy.get(i).setStocksToBeTraded(0);
			sell.get(j).setStocksToBeTraded(0);
		}
		return traded;
	}
	public  void updateStatusOfOrders(List<Order> buy,List<Order> sell) {
		for(int i=0;i<buy.size();i++) {
			if(buy.get(i).getStocksToBeTraded()==0) {
				orderRepository.setOrderStatus(buy.get(i).getOrderId(),"finished");
			}
			else {
				orderRepository.setRemainingQuantity(buy.get(i).getOrderId(),buy.get(i).getStocksToBeTraded());
			}
		}
		for(int i=0;i<sell.size();i++) {
			if(sell.get(i).getStocksToBeTraded()==0) {
				orderRepository.setOrderStatus(sell.get(i).getOrderId(),"finished");
			}
			else {
				orderRepository.setRemainingQuantity(sell.get(i).getOrderId(),sell.get(i).getStocksToBeTraded());
			}
		}
	}
}
