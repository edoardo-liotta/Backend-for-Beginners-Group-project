package com.mcs.be.course.facade;

import com.mcs.be.course.dto.CustomerDto;
import com.mcs.be.course.exception.ElementNotFound;

public interface CustomerFacade {

	CustomerDto login(CustomerDto customerDto) throws ElementNotFound;

	CustomerDto register(CustomerDto customerDto);
}
