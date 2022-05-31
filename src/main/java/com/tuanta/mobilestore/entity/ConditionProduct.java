package com.tuanta.mobilestore.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "tblConditionProducts")
public class ConditionProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Condition_ID")
	private int conditionID;
	
	@Column(name = "Condition_Name")
	private String conditionName;
	
	@OneToMany(mappedBy = "conditionProduct", cascade = CascadeType.ALL)
	private Set<Product> product;

	public int getConditionID() {
		return conditionID;
	}

	public void setConditionID(int conditionID) {
		this.conditionID = conditionID;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
