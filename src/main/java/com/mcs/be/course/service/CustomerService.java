package com.mcs.be.course.service;

import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Customer;

public interface CustomerService {
	Customer getCustomerById(String id) throws ElementNotFound;

	Customer findCustomerById(String id);

	Customer save(Customer customer);
	
	Customer getCurrentCustomer();
	
	void setCurrentCustomer(Customer customer);
}
