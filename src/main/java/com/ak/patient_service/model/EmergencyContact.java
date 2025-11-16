package com.ak.patient_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmergencyContact {
    private String name;
    private String phone;
    private String relationship;
}
