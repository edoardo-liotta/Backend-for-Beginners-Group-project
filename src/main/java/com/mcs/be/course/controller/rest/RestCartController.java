package com.mcs.be.course.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcs.be.course.dto.CartDto;
import com.mcs.be.course.facade.CartFacade;

@RestController
@RequestMapping("/cart")
public class RestCartController {

	@Autowired
	private CartFacade cartFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public CartDto getCart() {
		return cartFacade.getCart();
	}
}
