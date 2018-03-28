package com.mcs.be.course.service;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.mcs.be.course.model.Customer;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class Session implements Serializable {
	
	private String customerId;

	public String getCustomer() {
		return customerId;
	}

	public void setCustomer(String customer) {
		this.customerId = customer;
	}

	public void reset() {
		this.customerId = null;
	}
	
	
}
