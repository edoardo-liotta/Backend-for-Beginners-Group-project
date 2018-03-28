package com.mcs.be.course.service;

import com.mcs.be.course.dto.SessionDto;

public interface SessionService {
	SessionDto getCurrentSession();

	void resetSession();
}
