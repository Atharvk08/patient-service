package com.ak.patient_service.dto;

import com.ak.patient_service.model.ClinicalStatus;
import com.ak.patient_service.model.Source;
import lombok.Data;

import java.sql.Date;

@Data
public class ConditionDto {
    private Long id;
    private Long patientId;
    private String name;
    private ClinicalStatus clinicalStatus;
    private Date onsetDate;
    private Source source;
}
