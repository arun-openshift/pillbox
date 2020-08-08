package com.patientcare.pillbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientcare.pillbox.entity.Pillbox;
import com.patientcare.pillbox.repo.PillboxRepo;

@Service
public class PillboxService {
	
	@Autowired
	public PillboxRepo pillboxRepo;
	
	public PillboxService(PillboxRepo pillboxRepo) {
		this.pillboxRepo = pillboxRepo;
	}
	
	public List<Pillbox> getAllPillbox() {
		return pillboxRepo.findAll();
	}
	
	public void addPillbox(Pillbox pillbox) {
		pillboxRepo.save(pillbox);
	}

}