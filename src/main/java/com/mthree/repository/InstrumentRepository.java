package com.mthree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.dto.InstrumentDTO;
import com.mthree.entity.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer>{

	@Query("SELECT new com.mthree.dto.InstrumentDTO(i.instrumentId, i.instrumentName,i.marketCap, i.price) from Instrument i")
	public List<InstrumentDTO> getAllInstruments();
	
	@Query("SELECT i from Instrument i where i.instrumentId=:instrumentId")
	public Instrument getInstrument(int instrumentId);
}
