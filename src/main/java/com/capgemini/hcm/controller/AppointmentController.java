package com.capgemini.hcm.controller;

import com.capgemini.hcm.exception.TestException;
import com.capgemini.hcm.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/************************************************************************************
 *  
 *         Description 		Appointment controller class which provides functionality of
 *         					approving the test appointment taken by user and also
 *        					handle the exception.
 * 
 *         Created Date 	17-MAY-2020
 *         
 *         @author          Deepak Bharti
 ************************************************************************************/
@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    /************************************************************************************
	 * Method: approveappointment
     *Description: 			To approveappointment for a test under a particular diagnostic center.
	 * @param centerId       - testAppointmentId
	 * @returns String       - Appointment approved.
	 * @throws TestException - It is raised if appointment not found.
	 * 
	 * @author Deepak Bharti
	 ************************************************************************************/
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/approveAppointment/{testAppointmentId}")
    public ResponseEntity<String> approveappointment(@PathVariable Integer testAppointmentId) throws TestException {
        try {
            appointmentService.approveAppointment(testAppointmentId, true);
            return new ResponseEntity<>("Appointment approved", HttpStatus.OK);
        } catch (Exception exception) {
            throw new TestException(exception.getMessage());
        }
    }
}
