package com.mthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.repository.ExchangeRepository;

@Service
public class ExchangeService {

	@Autowired
	private ExchangeRepository exchangeRepo;
}
