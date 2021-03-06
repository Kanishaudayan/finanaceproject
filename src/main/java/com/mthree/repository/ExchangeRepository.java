package com.mthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.entity.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer>{

}
