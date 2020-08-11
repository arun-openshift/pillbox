package com.patientcare.pillbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = {"/pillConsumed"}, method = RequestMethod.GET)
	public ResponseEntity<String> pillConsumed(@RequestParam Integer pillboxid) {
		System.out.println(pillboxService.getPillboxById(pillboxid));
		Pillbox pillbox = pillboxService.getPillboxById(pillboxid).get();
		pillbox.setConsumed(pillbox.getConsumed() + 1);
		pillbox.setRemaining(pillbox.getRemaining() - 1);
		pillboxService.addPillbox(pillbox);
		return new ResponseEntity<String>("success", HttpStatus.OK); 
	}
	
	@RequestMapping(value = {"/pillboxDisconnected"}, method = RequestMethod.GET)
	public ResponseEntity<String> pillDisconnected(@RequestParam String payload) {
		String arr[] = payload.split(" ", 2);

		Integer pillboxid = Integer.parseInt(arr[0]);
		String status = arr[1];
		System.out.println(pillboxid);
		System.out.println(status);
		Pillbox pillbox = pillboxService.getPillboxById(pillboxid).get();
		pillbox.setStatus(status);
		pillboxService.addPillbox(pillbox);
		return new ResponseEntity<String>("success", HttpStatus.OK); 
	}

}
