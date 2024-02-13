package com.DoctorApi.blog.Service;

import java.util.List;

import com.DoctorApi.blog.Dto.DoctorDto;


public interface DoctorService 
{
	DoctorDto createDoctor(DoctorDto doctor);
	  
	DoctorDto updateDoctor(DoctorDto doctor,Integer doctorId);
	  
	DoctorDto getDoctorById(Integer doctorId);
	  
	void deleteDoctor(Integer doctorId);
	  
	List<DoctorDto> getAllDoctor();
	
	DoctorDto logIn(String username,String password);
}
