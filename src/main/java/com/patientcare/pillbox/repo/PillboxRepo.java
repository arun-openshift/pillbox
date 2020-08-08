package com.patientcare.pillbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientcare.pillbox.entity.Pillbox;

public interface PillboxRepo extends JpaRepository<Pillbox, Integer> {

}