package com.mthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	public User findUserByUserName(String username);
}
