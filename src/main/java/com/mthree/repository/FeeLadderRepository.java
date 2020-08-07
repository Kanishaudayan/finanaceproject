package com.mthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.entity.Exchange;
import com.mthree.entity.FeeLadder;
@Repository
public interface FeeLadderRepository extends JpaRepository<FeeLadder,Integer>{


	@Query("SELECT f from FeeLadder f join f.exchange e where e.exchangeId=:exchangeId")
	public FeeLadder getFeeLadder(int exchangeId);
}
