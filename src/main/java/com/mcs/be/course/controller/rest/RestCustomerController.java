package com.mcs.be.course.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcs.be.course.dto.CustomerDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.CustomerFacade;

@RestController
@RequestMapping("/customer")
public class RestCustomerController {

	@Autowired
	private CustomerFacade customerFacade;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CustomerDto doLogin(@RequestBody CustomerDto customerDto) throws ElementNotFound {
		return customerFacade.login(customerDto);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<CustomerDto> doSignup(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(customerFacade.register(customerDto), HttpStatus.CREATED);
	}
}
