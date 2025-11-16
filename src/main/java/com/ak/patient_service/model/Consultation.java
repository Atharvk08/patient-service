package com.ak.patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patient_id;
    private Long doctor_id;
    private String notes;
    private Long hospital_id;
    private Long consent_id;

    private List<Medication> medications;
    private Timestamp visitedOn;

    // todo future scope -> follow ups
}
