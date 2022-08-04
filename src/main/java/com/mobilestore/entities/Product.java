package com.mobilestore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "description", nullable = false, length = 260)
    private String description;

    @Column(name = "image", length = 1050)
    private String image;

    @Column(name = "unitPrice", nullable = false, precision = 19, scale = 4)
    private double unitPrice;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "manufacturer", nullable = false, length = 40)
    private String manufacturer;

    @Column(name = "condition", nullable = false, length = 20)
    private String condition;
    
    

	public Product() {
		super();
	}

	public Product(Integer id, String name, String description, String image, double unitPrice, Integer stock,
			String manufacturer, String condition) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.unitPrice = unitPrice;
		this.stock = stock;
		this.manufacturer = manufacturer;
		this.condition = condition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
    
    
}