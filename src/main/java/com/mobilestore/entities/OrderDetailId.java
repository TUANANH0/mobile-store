package com.mobilestore.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable {
    private static final long serialVersionUID = 5936945607316742506L;

    @Column(name = "orderid", nullable = false)
    private Integer orderid;
    @Column(name = "productCode", nullable = false)
    private Integer productCode;
    
    
    
	public OrderDetailId() {
		super();
	}
	public OrderDetailId(Integer orderid, Integer productCode) {
		super();
		this.orderid = orderid;
		this.productCode = productCode;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProductCode() {
		return productCode;
	}
	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}
    
    
}