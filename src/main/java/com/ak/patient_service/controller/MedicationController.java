package com.ak.patient_service.controller;

import com.ak.patient_service.dto.MedicationDto;
import com.ak.patient_service.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consultations/{consultationId}/medications")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @PostMapping
    public ResponseEntity<MedicationDto> addMedication(
            @PathVariable Long consultationId,
            @Validated @RequestBody MedicationDto dto) {

        MedicationDto created = medicationService.addMedication(consultationId, dto);
        return ResponseEntity.created(
                URI.create("/api/consultations/" + consultationId + "/medications/" + created.getId())
        ).body(created);
    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<MedicationDto> updateMedication(
            @PathVariable Long consultationId,
            @PathVariable Long medicationId,
            @Validated @RequestBody MedicationDto dto) {

        return ResponseEntity.ok(
                medicationService.updateMedication(consultationId, medicationId, dto)
        );
    }

    @GetMapping
    public ResponseEntity<List<MedicationDto>> list(
            @PathVariable Long consultationId) {

        return ResponseEntity.ok(medicationService.listMedications(consultationId));
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<Void> deleteMedication(
            @PathVariable Long consultationId,
            @PathVariable Long medicationId) {

        medicationService.deleteMedication(consultationId, medicationId);
        return ResponseEntity.noContent().build();
    }
}

