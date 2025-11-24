package com.ak.patient_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
@Builder
public class Patient {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;
    private String email;
    private String address;

    @Embedded
    private EmergencyContact emergencyContact;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Allergy> allergies;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Condition> conditions;

    private Boolean isActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
