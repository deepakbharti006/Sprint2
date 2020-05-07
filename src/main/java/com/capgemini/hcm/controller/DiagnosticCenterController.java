package com.capgemini.hcm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.service.DiagnosticCenterService;

public class DiagnosticCenterController {

	@Autowired
	DiagnosticCenterService diagnosticCenterService;

	@CrossOrigin
	@GetMapping("/viewallcenter")
	public ResponseEntity<List<DiagnosticCenter>> getalltest() {
		List<DiagnosticCenter> diagnosticCenterList = diagnosticCenterService.show();
		return new ResponseEntity<List<DiagnosticCenter>>(diagnosticCenterList, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/addcenter")
	public ResponseEntity<String> addAccount(@Valid @RequestBody DiagnosticCenter diagnosticcenter, BindingResult bindingResult){
			diagnosticCenterService.addcenter(diagnosticcenter);
			return new ResponseEntity<String>("Center added successfully", HttpStatus.OK);
	}
}
