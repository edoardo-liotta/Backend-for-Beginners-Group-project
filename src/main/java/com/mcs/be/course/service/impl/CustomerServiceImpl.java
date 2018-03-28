package com.mcs.be.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.be.course.dao.CustomerDao;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Customer;
import com.mcs.be.course.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomerById(String id) throws ElementNotFound {
		Customer customer = customerDao.findOne(id);
		if (customer == null) {
			throw new ElementNotFound("Couldn't find a user named " + id);
		}
		return customer;
	}

}
