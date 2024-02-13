package com.DoctorApi.blog.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@Getter
public class PatientDto
{
	private int patientId;
    private String patientName;
    private String patientEmail;
    private String password;
    private String patientPhoneNumber;
    private String patientAddress;
    private String patientPhoto;
}
