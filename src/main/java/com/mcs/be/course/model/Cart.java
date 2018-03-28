package com.mcs.be.course.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CART_ID", nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, mappedBy="cart")
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	@OneToMany(mappedBy="cart")
	private List<CartEntry> entries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<CartEntry> entries) {
		this.entries = entries;
	}
	
	
}
