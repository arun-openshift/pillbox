package com.patientcare.pillbox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patientcare.pillbox.controller.PillboxController;
import com.patientcare.pillbox.entity.Pillbox;

@SpringBootTest
class PillboxApplicationTests {
	
	@Autowired
	PillboxController pillboxController;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllPillboxesTest() {
		pillboxController.getAllPillboxes();
	}
	
	@Test
	void addPillboxTest() {
		Pillbox pillbox = new Pillbox(1, "CONNECTED", 0, 10, "DAILY", "8:00");
		pillboxController.addPillbox(pillbox);
	}
	
	@Test
	void pillConsumedTest() {
		pillboxController.pillConsumed(1);
	}
	
	@Test
	void pillDisconnectedTest() {
		pillboxController.pillDisconnected("1 DISCONNECTED");
	}

}
