package com.ak.patient_service.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Allergy {
    @Id
    private Long id;
    private Long patientId;
    private String substanceCode;
    private String name;
    private Severity severity;
    private String reaction;
    private String source;
    private Long verifiedByDoctorId;
    private Boolean isActive;
    private Timestamp recordedAt;
    private Timestamp updatedAt;
}
