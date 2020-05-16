package com.capgemini.hcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.AppointmentDao;
import com.capgemini.hcm.entity.TestAppointment;

@Transactional
@Service
public class AppointmentService {
	
	@Autowired
	AppointmentDao appointmentDao;
	
	public void approveAppointment(TestAppointment appointment) {
		
		appointment.setApproved(true);
		appointmentDao.save(appointment);

	}

}
