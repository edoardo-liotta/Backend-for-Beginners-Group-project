package com.mcs.be.course.facade.impl;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.mcs.be.course.dto.CustomerDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.CustomerFacade;
import com.mcs.be.course.model.Customer;
import com.mcs.be.course.service.CustomerService;
import com.mcs.be.course.service.SessionService;

import ma.glasnost.orika.MapperFacade;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private MapperFacade mapperFacade;
	
	@Override
	public CustomerDto login(CustomerDto customerDto) throws ElementNotFound {
		if (sessionService.getCurrentSession().getCustomerDto() != null) {
			throw new IllegalArgumentException("Logout first");
		}
		
		Customer customerById = customerService.getCustomerById(customerDto.getId());
		if (!StringUtils.equals(customerDto.getPassword(), customerById.getPassword())) {
			throw new IllegalArgumentException("Wrong password");
		}
		
		CustomerDto loggedInCustomer = mapperFacade.map(customerById, CustomerDto.class);
		sessionService.getCurrentSession().setCustomerDto(loggedInCustomer);
		
		return loggedInCustomer;
	}
	
	@Override
	public void logout() {
		sessionService.resetSession();
	}

	@Override
	public CustomerDto register(CustomerDto customerDto) {
		String id = customerDto.getId();
		Customer existingCustomer = customerService.findCustomerById(id);
		if (existingCustomer != null) {
			throw new DuplicateKeyException("Customer with id " + id + " is already existing");
		}
		
		Customer newCustomer = mapperFacade.map(customerDto, Customer.class);
		Customer savedCustomer;
		try {
			savedCustomer = customerService.save(newCustomer);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
		
		return mapperFacade.map(savedCustomer, CustomerDto.class);
	}

}
