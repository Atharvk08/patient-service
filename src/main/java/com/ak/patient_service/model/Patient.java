package com.ak.patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private EmergencyContact emergencyContact;

    private List<Allergy> allergies;
    private List<Consultation> consultations;

    private Boolean isActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
