package com.mcs.be.course.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcs.be.course.dto.CartDto;
import com.mcs.be.course.facade.CartFacade;
import com.mcs.be.course.model.Cart;
import com.mcs.be.course.model.Customer;
import com.mcs.be.course.service.CartService;
import com.mcs.be.course.service.CustomerService;

import ma.glasnost.orika.MapperFacade;

@Component
public class CartFacadeImpl implements CartFacade {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private MapperFacade mapperFacade;
	
	@Override
	public CartDto getCart() {
		Customer currentCustomer = customerService.getCurrentCustomer();
		if (null == currentCustomer) {
			throw new IllegalStateException("customer not logged");
		}
		
		Cart cart = currentCustomer.getCart();
		if (null == cart) {
			cart = cartService.createCart(currentCustomer);
		}
		
		return mapperFacade.map(cart, CartDto.class);
	}

}
