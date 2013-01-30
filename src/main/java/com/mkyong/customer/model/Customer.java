package com.mkyong.customer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements java.io.Serializable {

	private Long customerId;
	private String name;
	private String address;
	private Date createdDate;

	public Customer() {
	}

	public Customer(String name, String address, Date createdDate) {
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

	public String getAddress() {
		return address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
