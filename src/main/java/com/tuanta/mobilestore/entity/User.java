package com.tuanta.mobilestore.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tblUser", uniqueConstraints = {
		@UniqueConstraint(name = "tblUser_PK", columnNames = { "User_Name" }) })
public class User {
	@Id
	@GeneratedValue
	@Column(name = "User_Name", nullable = false)
	private String userName;

	@Column(name = "Full_Name", length = 128, nullable = false)
	private String fullName;

	@Column(name = "Password", length = 128, nullable = false)
	private String password;

	@Column(name = "Role_ID", length = 1, nullable = false)
	private int roleID;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Order> order;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	
}
