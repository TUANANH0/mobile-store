package com.tuanta.mobilestore.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tblProducts")
public class Product {

	@javax.persistence.Id
	@GeneratedValue
	@Column(name = "Product_ID", nullable = false)
	private int productID;
	
	@Column(name = "Product_Name", length = 50, nullable = false)
	private String productName;
	
	@Column(name = "Description", length = 100, nullable = true)
	private String description;
	
	@Column(name = "Image", length = 50, nullable = true)
	private String image;
	
	@Column(name = "Quantity", nullable = false)
	private int quantity;
	
	@Column(name = "Price", nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "Category_ID")
	private CategoryProduct categoryProduct;
	
	@ManyToOne
	@JoinColumn(name = "Condition_ID")
	private ConditionProduct conditionProduct;
	
	@ManyToOne
	@JoinColumn(name = "Manufacturer_ID")
	private ManufacturerProduct manufacturerProduct;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderDetails> orderDetails;
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoryProduct getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoryProduct categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public ConditionProduct getConditionProduct() {
		return conditionProduct;
	}

	public void setConditionProduct(ConditionProduct conditionProduct) {
		this.conditionProduct = conditionProduct;
	}

	public ManufacturerProduct getManufacturerProduct() {
		return manufacturerProduct;
	}

	public void setManufacturerProduct(ManufacturerProduct manufacturerProduct) {
		this.manufacturerProduct = manufacturerProduct;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
