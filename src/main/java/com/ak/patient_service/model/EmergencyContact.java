package com.ak.patient_service.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class EmergencyContact {
    private String name;
    private String phoneNumber;
    private String relationship;
}
