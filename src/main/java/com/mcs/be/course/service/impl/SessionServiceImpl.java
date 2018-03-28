package com.mcs.be.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.be.course.service.Session;
import com.mcs.be.course.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private Session session;
	
	@Override
	public Session getCurrentSession() {
		return session;
	}

	@Override
	public void resetSession() {
		session.reset();
	}

}
