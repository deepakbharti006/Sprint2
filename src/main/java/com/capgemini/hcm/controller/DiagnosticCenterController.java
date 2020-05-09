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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.exception.DiagnosticCenterException;
import com.capgemini.hcm.service.DiagnosticCenterService;

@RestController
public class DiagnosticCenterController {

	@Autowired
	private DiagnosticCenterService diagnosticCenterService;

	@CrossOrigin
	@PostMapping("/addcenter")
	public ResponseEntity<String> addCenter(@Valid @RequestBody DiagnosticCenter diagnosticcenter, BindingResult br)
			throws DiagnosticCenterException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new DiagnosticCenterException(err);
		}
		try {
			diagnosticCenterService.addcenter(diagnosticcenter);
			return new ResponseEntity<String>("Center added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new DiagnosticCenterException("ID already exists");
		}
	}

	@CrossOrigin
	@GetMapping("/viewallcenter")
	public ResponseEntity<List<DiagnosticCenter>> getDiagnosticCenterlist() {
		List<DiagnosticCenter> diagnosticCenterList = diagnosticCenterService.show();
		return new ResponseEntity<List<DiagnosticCenter>>(diagnosticCenterList, HttpStatus.OK);
	}
}
