package com.mcs.be.course.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.be.course.dao.CartDao;
import com.mcs.be.course.dao.CustomerDao;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Cart;
import com.mcs.be.course.model.Customer;
import com.mcs.be.course.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Cart getCart(Long id) throws ElementNotFound {
		Cart findOne = cartDao.findOne(id);
		if (findOne == null) {
			throw new ElementNotFound("Couldn't find cart for id " + id);
		}
		
		return findOne;
	}

	@Override
	public Cart createCart(Customer customer) {
		Cart newCart = new Cart();
		newCart.setEntries(Collections.emptyList());
		Cart savedCart = cartDao.save(newCart);
		customer.setCart(savedCart);
		customerDao.save(customer);
		return savedCart;
	}

}
