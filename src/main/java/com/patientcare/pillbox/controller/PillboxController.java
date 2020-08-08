package com.patientcare.pillbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patientcare.pillbox.entity.Pillbox;
import com.patientcare.pillbox.service.PillboxService;


@Controller
public class PillboxController {
	
	@Autowired
	PillboxService pillboxService;
	
	@RequestMapping(value = { "/getAllPillboxes" }, method = RequestMethod.GET)
	public ResponseEntity<List<Pillbox>> getAllPillboxes() {
		return new ResponseEntity<List<Pillbox>>(pillboxService.getAllPillbox(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = { "/addPillbox" }, method = RequestMethod.POST)
	public ResponseEntity<String> addPillbox(@RequestBody Pillbox pillbox) {
		pillboxService.addPillbox(pillbox);
		return new ResponseEntity<String>("pillbox added", HttpStatus.OK);
	}

}
