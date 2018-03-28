package com.mcs.be.course.facade.impl;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcs.be.course.dto.CustomerDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.CustomerFacade;
import com.mcs.be.course.model.Customer;
import com.mcs.be.course.service.CustomerService;

import ma.glasnost.orika.MapperFacade;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MapperFacade mapperFacade;
	
	@Override
	public CustomerDto login(CustomerDto customerDto) throws ElementNotFound {
		Customer customerById = customerService.getCustomerById(customerDto.getId());
		if (!StringUtils.equals(customerDto.getPassword(), customerById.getPassword())) {
			throw new IllegalArgumentException("Wrong password");
		}
		return mapperFacade.map(customerById, CustomerDto.class);
	}

}
