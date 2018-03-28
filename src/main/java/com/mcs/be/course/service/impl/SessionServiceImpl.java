package com.mcs.be.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.be.course.dto.SessionDto;
import com.mcs.be.course.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionDto session;
	
	@Override
	public SessionDto getCurrentSession() {
		return session;
	}

	@Override
	public void resetSession() {
		session.setCustomerDto(null);
	}

}
