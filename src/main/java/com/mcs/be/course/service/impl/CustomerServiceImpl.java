package com.mcs.be.course.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.be.course.dao.CustomerDao;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Customer;
import com.mcs.be.course.service.CustomerService;
import com.mcs.be.course.service.SessionService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionService sessionService;

	@Override
	public Customer getCustomerById(String id) throws ElementNotFound {
		Customer customer = findCustomerById(id);
		if (customer == null) {
			throw new ElementNotFound("Couldn't find a user named " + id);
		}
		return customer;
	}

	@Override
	public Customer findCustomerById(String id) {
		return customerDao.findOne(id);
	}

	@Override
	public Customer save(Customer customer) {
		Objects.requireNonNull(customer.getId(), "the id cannot be null");
		Objects.requireNonNull(customer.getFirstName(), "the first name cannot be null");
		Objects.requireNonNull(customer.getLastName(), "the last name cannot be null");
		Objects.requireNonNull(customer.getPassword(), "the password cannot be null");

		return customerDao.save(customer);
	}

	@Override
	public Customer getCurrentCustomer() {
		String id = sessionService.getCurrentSession().getCustomer();
		return id != null ? customerDao.findOne(id) : null;
	}

	@Override
	public void setCurrentCustomer(Customer customer) {
		sessionService.getCurrentSession().setCustomer(customer.getId());
	}
}
