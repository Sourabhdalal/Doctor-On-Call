package com.DoctorApi.blog.Service;

import java.util.ArrayList;
import java.util.List;

import com.DoctorApi.blog.Dto.DoctorDto;
import com.DoctorApi.blog.Dto.PrescriptionDto;
import com.DoctorApi.blog.Entity.Patient;


public interface DoctorService 
{
	DoctorDto createDoctor(DoctorDto doctor);
	  
	DoctorDto updateDoctor(DoctorDto doctor,Integer doctorId);
	  
	DoctorDto getDoctorById(Integer doctorId);
	  
	void deleteDoctor(Integer doctorId);
	  
	List<DoctorDto> getAllDoctor();
	
	DoctorDto logIn(String username,String password);
	
	DoctorDto deletePatient(Integer doctorId, Integer patientId);
	
	DoctorDto acceptPatient(Integer doctorId, Integer patientId);
	
	DoctorDto generatePrescription(PrescriptionDto prescDto, Integer doctorId, Integer patientId);
	
	ArrayList<Patient> unAcceptedPatient(Integer doctorId);
}
