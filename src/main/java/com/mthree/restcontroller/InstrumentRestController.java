package com.mthree.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dto.InstrumentDTO;
import com.mthree.entity.Instrument;
import com.mthree.repository.InstrumentRepository;
import com.mthree.service.InstrumentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InstrumentRestController {

	@Autowired
	public InstrumentService instrumentServ;
	
	@Autowired
	public InstrumentRepository is;
	
	//private List<InstrumentDTO> instruments;
	
	@GetMapping("/instruments")
	public List<InstrumentDTO> getAllInstruments() {
		return instrumentServ.getAllInstruments();
	}
}
