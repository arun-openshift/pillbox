package com.patientcare.pillbox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pillbox")
public class Pillbox {
	
	@Id
	@Column(name="pillboxid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pillboxid;
	
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="status")
	private String status;
	
	@Column(name="consumed")
	private Integer consumed;
	
	@Column(name="remaining")
	private Integer remaining;
	
	@Column(name="frequency")
	private String frequency;
	
	@Column(name="time")
	private String time;

	public Integer getPillboxid() {
		return pillboxid;
	}

	public void setPillboxid(Integer pillboxid) {
		this.pillboxid = pillboxid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getConsumed() {
		return consumed;
	}

	public void setConsumed(Integer consumed) {
		this.consumed = consumed;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Pillbox(Integer userid, String status, Integer consumed, Integer remaining, String frequency, String time) {
		super();
		this.userid = userid;
		this.status = status;
		this.consumed = consumed;
		this.remaining = remaining;
		this.frequency = frequency;
		this.time = time;
	}

	public Pillbox() {
		super();
	}

}

