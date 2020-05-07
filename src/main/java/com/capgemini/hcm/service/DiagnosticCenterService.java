package com.capgemini.hcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.entity.DiagnosticCenter;

@Service
public class DiagnosticCenterService {

	@Autowired
	private DiagnosticCenterDao diagnosticCenterDao;

	@Transactional
	public boolean addcenter(DiagnosticCenter diagnosticcenter) {
		return diagnosticCenterDao.save(diagnosticcenter) != null;
	}

	@Transactional
	public List<DiagnosticCenter> show() {
		return diagnosticCenterDao.findAll();
	}

	@Transactional

	public void deletecenter(DiagnosticCenter diagnosticcenter) {
		diagnosticCenterDao.delete(diagnosticcenter);
	}

	@Transactional
	public DiagnosticCenter updatecenter(DiagnosticCenter diagnosticcenter, String centerId) {
		return diagnosticCenterDao.save(diagnosticcenter);
	}

}
