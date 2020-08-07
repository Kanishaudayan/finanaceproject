package com.mthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.repository.OrderBookRepository;

@Service
public class OrderBookService {

	@Autowired
	private OrderBookRepository orderBookRepo;
}
