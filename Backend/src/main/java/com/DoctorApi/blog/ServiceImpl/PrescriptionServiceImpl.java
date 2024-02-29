package com.DoctorApi.blog.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoctorApi.blog.Dto.PrescriptionDto;
import com.DoctorApi.blog.Entity.Doctor;
import com.DoctorApi.blog.Entity.Patient;
import com.DoctorApi.blog.Entity.Prescription;
import com.DoctorApi.blog.Repository.DoctorRepo;
import com.DoctorApi.blog.Repository.PatientRepo;
import com.DoctorApi.blog.Repository.PrescriptionRepo;
import com.DoctorApi.blog.Service.PrescriptionService;
import com.DoctorApi.blog.exception.ResourceNotFoundException;


@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepo prescriptionRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PrescriptionDto generatePrescription(PrescriptionDto ps, Integer patientId, Integer doctorId) {
		
		Prescription pres=this.modelMapper.map(ps, Prescription.class);
		Doctor d=this.doctorRepo.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("doctor","id",doctorId));
		Patient p=this.patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient","id",patientId));
		
		
		pres.setDoctor(d);
		pres.setPatient(p);
		d.setPrescriptionStatus(true);
		p.setPrescriptionStatus(true);
		System.out.println(pres.getDoctor());
		System.out.println(pres.getPatient());
		
		Prescription updatedPres=this.prescriptionRepo.save(pres);
		
		return this.modelMapper.map(updatedPres,PrescriptionDto.class);
	}

	@Override
	public PrescriptionDto getPrescription(Integer doctorId,Integer patientId) {
		List<Prescription> p=this.prescriptionRepo.findAll();
		
		
//		System.out.println(p);
		
//		System.out.println(p.get(0).getId());
		
//		Prescription p=this.prescriptionRepo.findById(6).orElseThrow(() -> new ResourceNotFoundException("prescription","id",6));
		
////		System.out.println(p.get(0).getDoctor().getDoctorId());
		
		boolean flag=false;
		
		for(Prescription ps:p)
		{
		    System.out.println(ps.getId());
			if(ps.getDoctor().getDoctorId()==doctorId && ps.getPatient().getPatientId()==patientId)
			{
				 System.out.println("yes");
				 flag=true;
		         return this.modelMapper.map(ps, PrescriptionDto.class);
		    }
		}
		
		if(!flag)
		{
			Prescription pres=this.prescriptionRepo.findById(61919).orElseThrow(() -> new ResourceNotFoundException("prescription","id",6191));
		}
		
		return this.modelMapper.map(p.get(0), PrescriptionDto.class);
	}

}
