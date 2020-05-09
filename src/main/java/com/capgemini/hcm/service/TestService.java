package com.capgemini.hcm.service;

import java.util.List;

import com.capgemini.hcm.entity.Tests;

public interface TestService {

	boolean addTest(Tests tests);

	List<Tests> showalltest();
	
	void deletetest(int testId);
}
