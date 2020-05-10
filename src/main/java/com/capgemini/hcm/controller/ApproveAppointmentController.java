package com.capgemini.hcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.entity.Appointment;
import com.capgemini.hcm.service.ApproveAppointmentService;

@RestController
public class ApproveAppointmentController {

	@Autowired
	ApproveAppointmentService approveAppointmentService;

	@PutMapping("/approveAppointment")
	public ResponseEntity<String> approveappointment(@RequestBody Appointment appointment) {
		approveAppointmentService.approveAppointment(appointment);
		return new ResponseEntity<String>("Appointment approved", HttpStatus.OK);
	}

}
