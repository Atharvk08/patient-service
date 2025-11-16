package com.ak.patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Allergy {
    @Id
    private Long id;
    private String name;
    private Severity severity;
    private String reaction;
    private String source;
}
