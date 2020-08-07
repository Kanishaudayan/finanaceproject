package com.mthree.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.dto.OrderDto;
import com.mthree.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{


	//@Query("SELECT o from Order o where o.orderType =:orderType and o.instrumentId.instrumentId =:instrumentId and o.orderBookId.orderBookId =:orderBookId and o.status =:status")
	//@Query("SELECT new com.mthree.dto.OrderDto(o.orderId,o.quantity,o.price,o.status,o.orderType,o.stocksToBeTraded,o.orderBookId,o.userId,o.instrumentId) from Order o LEFT JOIN o.instrumentId i LEFT JOIN o.orderBookId ob where i.instrumentId=:instrumentId and ob.orderBookId=:orderBookId and o.status=:status and o.orderType=:orderType")
	@Query("SELECT o from Order o LEFT JOIN o.instrumentId i LEFT JOIN o.orderBookId ob where i.instrumentId=:instrumentId and ob.orderBookId=:orderBookId and o.status=:status and o.orderType=:orderType")
	public List<Order> getOrdersFromOrderBook(String orderType, int instrumentId, int orderBookId,String status);
	
	@Query("SELECT o from Order o LEFT JOIN o.instrumentId i LEFT JOIN o.orderBookId ob where i.instrumentId=:instrumentId and ob.orderBookId=:orderBookId and o.status=:status and o.orderType=:orderType ORDER BY o.price DESC")
	public List<Order> getBuyOrdersFromOrderBook(String orderType, int instrumentId, int orderBookId,String status);
	
	@Query("SELECT o from Order o LEFT JOIN o.instrumentId i LEFT JOIN o.orderBookId ob where i.instrumentId=:instrumentId and ob.orderBookId=:orderBookId and o.status=:status and o.orderType=:orderType ORDER BY o.price ASC")
	public List<Order> getSellOrdersFromOrderBook(String orderType, int instrumentId, int orderBookId,String status);
	
	@Query("UPDATE Order o SET o.status=:orderStatus where o.orderId=:orderId")
	@Modifying
	@Transactional
	public int setOrderStatus(int orderId, String orderStatus);
	
	@Query("UPDATE Order o SET o.stocksToBeTraded=:quantity where o.orderId=:orderId")
	@Modifying
	@Transactional
	public int setRemainingQuantity(int orderId, int quantity);
	
	@Query(value="UPDATE order_table o SET o.orderbook_id=:orderBookId where o.order_id=:orderId",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateOrderBookByIdInOrder(int orderBookId,int orderId);
	
	@Query("Select o.stocksToBeTraded FROM Order o WHERE o.orderId=:orderId")
	public int getOrderQuantityByOrderId(int orderId);
}
