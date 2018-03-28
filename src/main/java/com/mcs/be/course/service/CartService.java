package com.mcs.be.course.service;

import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Cart;
import com.mcs.be.course.model.Customer;

public interface CartService {
	Cart getCart(Long id) throws ElementNotFound;
	
	Cart createCart(Customer customer);
}
