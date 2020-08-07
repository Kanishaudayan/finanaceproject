package com.mthree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.entity.User;
import com.mthree.service.UserService;

@SpringBootTest
class FinanceProjectApplicationTests {
	@Autowired
	private UserService userService;
	
	@Test
	void registeruser() {
		User actual=new User(4,"user4","6789","user4@gmail.com");
		User expected=userService.registerUser(actual);
		assertEquals(actual.toString(),expected.toString());
	}

	@Test
	void getUser() {
		String username="user1";
		User actual=new User(1,"user1","12345","user1@gmail.com");
		User expected= userService.getUserByUserName(username);
		assertEquals(actual.getPassword(),expected.getPassword());
	}
	
	@Test
	void getUser2() {
		String username="user2";
		User actual=new User(2,"user2","23456","user2@gmail.com");
		User expected= userService.getUserByUserName(username);
		assertEquals(actual.getPassword(),expected.getPassword());
	}

}
