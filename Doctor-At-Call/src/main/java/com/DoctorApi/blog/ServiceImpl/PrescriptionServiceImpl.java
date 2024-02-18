package com.DoctorApi.blog.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoctorApi.blog.Dto.PrescriptionDto;
import com.DoctorApi.blog.Entity.Prescription;
import com.DoctorApi.blog.Repository.PrescriptionRepo;
import com.DoctorApi.blog.Service.PrescriptionService;


@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepo prescriptionRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PrescriptionDto generatePrescription(PrescriptionDto ps, Integer patientId, Integer doctorId) {
		
		Prescription p=this.modelMapper.map(ps, Prescription.class);
		
		return this.modelMapper.map(p,PrescriptionDto.class);
	}

}
