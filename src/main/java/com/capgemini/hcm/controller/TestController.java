package com.capgemini.hcm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.entity.Tests;
import com.capgemini.hcm.exception.TestsException;
import com.capgemini.hcm.service.TestService;

@RestController
public class TestController {

	@Autowired
	TestService testService;

	@CrossOrigin
	@GetMapping("/viewalltest")
	public ResponseEntity<List<Tests>> getalltest() {
		List<Tests> testList = testService.showalltest();
		return new ResponseEntity<List<Tests>>(testList, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/addtest")
	public ResponseEntity<String> addAccount(@Valid @RequestBody Tests tests, BindingResult bindingResult)
			throws TestsException {
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new TestsException(err);
		}
		try {
			testService.addTest(tests);
			return new ResponseEntity<String>("Test added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new TestsException("Test ID already exists");
		}
	}

//	@DeleteMapping(value = "/deletetest/{id}")
//	public ResponseEntity<String> deleteTest(@Valid @RequestParam int testId, BindingResult bindingResult)
//			throws TestsException {
//		String err = "";
//		if (bindingResult.hasErrors()) {
//			List<FieldError> errors = bindingResult.getFieldErrors();
//			for (FieldError error : errors)
//				err += error.getDefaultMessage() + "<br/>";
//			throw new TestsException(err);
//		}
//		try {
//			testService.deletetest(testId);
//			return new ResponseEntity<String>("Test deleted successfully", HttpStatus.OK);
//
//		} catch (DataIntegrityViolationException ex) {
//			throw new TestsException("Test ID not exists");
//		}
//	}
	
	@DeleteMapping(value = "/deletetest/{id}")
	public ResponseEntity<String> deleteTest(@Valid @RequestParam int testId)
			throws TestsException {
		try {
			testService.deletetest(testId);
			return new ResponseEntity<String>("Test deleted successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new TestsException("Test ID not exists");
		}
	}

}
