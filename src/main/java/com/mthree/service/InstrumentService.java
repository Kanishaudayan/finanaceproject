package com.mthree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dto.InstrumentDTO;
import com.mthree.repository.InstrumentRepository;

@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepo;
	
	public List<InstrumentDTO> getAllInstruments(){
		return instrumentRepo.getAllInstruments();
	}
}
