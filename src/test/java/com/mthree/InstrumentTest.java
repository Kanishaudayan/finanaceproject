package com.mthree;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mthree.service.InstrumentService;
import com.mthree.dto.InstrumentDTO;

import java.util.List;


@SpringBootTest
public class InstrumentTest {
	@Autowired
	private InstrumentService instrumentService; 
	
	@Test
	void getFirstInstruments() {
		List<InstrumentDTO> i=instrumentService.getAllInstruments();
		InstrumentDTO i1=new InstrumentDTO(1, "TATA Motors", "low",94.1);
		assertEquals(i1.toString(),i.get(0).toString());
	}
	@Test
	void getSecondInstruments() {
		List<InstrumentDTO> i=instrumentService.getAllInstruments();
		InstrumentDTO i1=new InstrumentDTO(2, "Mahindra", "low",537.95);
		assertEquals(i1.toString(),i.get(1).toString());
	}

}

