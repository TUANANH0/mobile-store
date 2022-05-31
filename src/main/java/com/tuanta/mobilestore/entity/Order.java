package com.tuanta.mobilestore.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblOrder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "CreateDate")
	private Date createDate;

	@Column(name = "Address")
	private String address;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderDetails> orderDetail;

	@ManyToOne
	@JoinColumn(name = "User_Name")
	private User user;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<OrderDetails> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetails> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
