package com.DoctorApi.blog.Dto;

import com.DoctorApi.blog.Entity.Doctor;
import com.DoctorApi.blog.Entity.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PrescriptionDto 
{
	private int Id;
	
	private String dieases;
	private String tablet;
	private String date;
	private String time;
	
	@JsonIgnore
	private Doctor doctor;

	@JsonIgnore
	private Patient patient;
	
}
