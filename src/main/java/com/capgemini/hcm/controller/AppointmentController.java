package com.capgemini.hcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.entity.TestAppointment;
import com.capgemini.hcm.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentService approveAppointmentService;

	@PutMapping("/approveAppointment/{testAppointmentId}")
	public ResponseEntity<String> approveappointment(@RequestBody TestAppointment appointment, @PathVariable Integer testAppointmentId) {
		appointment.setTestAppointmentId(testAppointmentId);
		approveAppointmentService.approveAppointment(appointment);
		return new ResponseEntity<String>("Appointment approved", HttpStatus.OK);
	}
}
