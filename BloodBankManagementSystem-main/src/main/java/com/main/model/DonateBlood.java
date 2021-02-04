package com.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "donate_blood")
public class DonateBlood {
	@Id
	@NotNull
	private Integer patient_id;
	@NotEmpty
	private String patientname;
	@NotEmpty
	private String time_of_the_day;
	@NotEmpty
	private String glucose_level;
	@NotEmpty
	private String notes;
	@NotEmpty
	private String username;

	public String getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getTime_of_the_day() {
		return time_of_the_day;
	}

	public void setTime_of_the_day(String time_of_the_day) {
		this.time_of_the_day = time_of_the_day;
	}

	public String getGlucose_level() {
		return glucose_level;
	}

	public void setGlucose_level(String glucose_level) {
		this.glucose_level = glucose_level;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
