package com.ak.patient_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "conditions")
@Builder
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String name;

    @Enumerated(EnumType.STRING)
    private ClinicalStatus clinicalStatus;

    private Date onsetDate;
    private Timestamp recordedAt;
    private Timestamp updatedAt;

    @Enumerated(EnumType.STRING)
    private Source source;

    @PrePersist
    public void prePersist(){
        this.recordedAt = Timestamp.valueOf(LocalDateTime.now());
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
