package com.DoctorApi.blog.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto
{
	private int doctorId;
    private String doctorName;
    private String doctorEmail;
    private String password;
    private String doctorPhoneNumber;
    private String doctorEducation;
    private String doctorePhoto;
}
