package com.mthree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="user_table")
public class User {
	
	@Id
	@GeneratedValue
    @Column(name="user_id")
    private int userId; 
	
	@Column(name="user_name")
    private String userName; 
	
	@Column(name="user_password")
    private String password; 
	
	@Column(name="user_email")
    private String email; 
	
	@OneToMany(mappedBy = "userId")
	@JsonBackReference
    private List<Order> orders = new ArrayList<>();

	public User() {}
	
	public User(int userId, String userName, String password, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	

	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public User(int userId, String userName, String password, String email, List<Order> orders) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.orders = orders;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", orders=" + orders + "]";
	}
	
	

}
