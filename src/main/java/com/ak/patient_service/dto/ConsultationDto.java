package com.ak.patient_service.dto;

import lombok.Data;
import org.hibernate.annotations.SecondaryRow;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ConsultationDto {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long hospitalId;
    private Long consentId;
    private String notes;
    private Timestamp visitedOn;
    private List<MedicationDto> medications;
}
