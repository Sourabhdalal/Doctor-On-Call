package com.DoctorApi.blog.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoctorApi.blog.Dto.DoctorDto;
import com.DoctorApi.blog.Entity.Doctor;
import com.DoctorApi.blog.Repository.DoctorRepo;
import com.DoctorApi.blog.Service.DoctorService;
import com.DoctorApi.blog.exception.ResourceNotFoundException;



@Service
public class DoctorServiceImpl implements DoctorService {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DoctorRepo doctorRepo;
	

	@Override
	public DoctorDto createDoctor(DoctorDto doctor) {
		
		Doctor d=this.modelMapper.map(doctor,Doctor.class);
		
		this.doctorRepo.save(d);
	
		return this.modelMapper.map(d, DoctorDto.class);
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctor, Integer doctorId) {
		
		Doctor d=this.doctorRepo.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("doctor","id",doctorId));
		
		d.setDoctorEducation(doctor.getDoctorEducation());
		d.setDoctorEmail(doctor.getDoctorEmail());
		d.setDoctorePhoto(doctor.getDoctorePhoto());
		d.setDoctorPhoneNumber(doctor.getDoctorPhoneNumber());
		d.setPassword(doctor.getPassword());
		
		Doctor updatedDoctor=this.doctorRepo.save(d);
		
		return this.modelMapper.map(updatedDoctor, DoctorDto.class);
	}

	@Override
	public DoctorDto getDoctorById(Integer doctorId) {
		
		Doctor d=this.doctorRepo.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("doctor","id",doctorId));
		return this.modelMapper.map(d,DoctorDto.class);
	}

	@Override
	public void deleteDoctor(Integer doctorId) {
		this.doctorRepo.deleteById(doctorId);
	}

	@Override
	public List<DoctorDto> getAllDoctor() {
		
		List<Doctor> doctorList=this.doctorRepo.findAll();
		
		List<DoctorDto> doctorDtoList=doctorList.stream().map(doctor->this.modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
		
		return doctorDtoList;
	}

	@Override
	public DoctorDto logIn(String username, String password) {
		
		Optional<Doctor> d=this.doctorRepo.findByUsernameAndPassword(username, password);
		
		if(d.isPresent())
		{
			//System.out.println(d);
		   return this.modelMapper.map(d.get(),DoctorDto.class);
		}
		return null;
	}
	
	

}
