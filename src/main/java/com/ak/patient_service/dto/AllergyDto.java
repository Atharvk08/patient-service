package com.ak.patient_service.dto;

import com.ak.patient_service.model.Severity;
import lombok.Data;

@Data
public class AllergyDto {
    private Long id;
    private Long patientId;
    private String substanceCode;
    private String substanceName;
    private Severity severity;
    private String reaction;
    private String source;
    private Long verifiedByDoctorId;
    private Boolean isActive;
}
