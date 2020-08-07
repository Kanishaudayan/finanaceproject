package com.mthree.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.entity.User;
import com.mthree.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {

	@Autowired
	private UserService userServ;
	
	@PostMapping(value="/register",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registerUser(@RequestBody Map<String,String> user) {
		User u=new User(user.get("userName"),user.get("email"),user.get("password"));
		userServ.registerUser(u);
		return true;
	}
	
	@PostMapping("/verifyLogin")
	public boolean verifyLogin(@RequestBody Map<String,String> params) {
		
		User u = userServ.getUserByUserName(params.get("userName"));
		if(u == null) {
			return true;
		}
		else if(!(u.getPassword()).equals(params.get("password"))) {
			return true;
		}
		else {
			return false;
		}
	}
}