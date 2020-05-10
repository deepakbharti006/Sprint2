package com.capgemini.hcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.AppointmentDao;
import com.capgemini.hcm.entity.Appointment;

@Transactional
@Service
public class ApproveAppointmentService {

	@Autowired
	AppointmentDao appointmentDao;
	
	public void approveAppointment(Appointment appointment) {
		
		appointment.setApproved(true);
		appointmentDao.save(appointment);

	}
}
