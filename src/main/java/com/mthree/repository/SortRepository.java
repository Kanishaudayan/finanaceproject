package com.mthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.entity.Sort;

@Repository
public interface SortRepository extends JpaRepository<Sort, Integer>{

}
