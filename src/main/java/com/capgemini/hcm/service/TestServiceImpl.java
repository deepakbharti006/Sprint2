package com.capgemini.hcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.TestDao;
import com.capgemini.hcm.entity.Tests;

@Transactional
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public boolean addTest(Tests tests) {
		Tests testresult = testDao.save(tests);
		if (testresult != null) {
			return true;
		} else
			return false;
	}

	@Override
	public List<Tests> showalltest() {
		return testDao.findAll();
	}

	@Override
	public void deletetest(int testId) {
		testDao.deleteById(testId);
	}

}
