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
@Table(name = "tblManufacturerProduct")
public class ManufacturerProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Manufacturer_ID")
	private int manufacturerID;
	
	@Column(name = "Manufacturer_Name")
	private String manufacturerName;
	
	@OneToMany(mappedBy = "manufacturerProduct", cascade = CascadeType.ALL)
	private Set<Product>  product;

	public int getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
		
	
}
