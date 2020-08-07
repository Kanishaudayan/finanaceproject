package com.mthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.repository.SortRepository;

@Service
public class SortService {

	@Autowired
	private SortRepository sortRepo;
}
