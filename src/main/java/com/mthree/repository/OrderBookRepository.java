package com.mthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.entity.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {

}
