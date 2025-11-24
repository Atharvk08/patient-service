package com.ak.patient_service.dto;

import com.ak.patient_service.model.EmergencyContact;
import lombok.Data;

import java.sql.Date;

@Data
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private EmergencyContact emergencyContact;
}
