package com.ak.patient_service.dto;

import lombok.Data;

@Data
public class MedicationDto {
    private Long id;
    private String name;
    private String dosage;
    private String duration;
    private String instructions;
}
