package com.ak.patient_service.controller;

import com.ak.patient_service.dto.AllergyDto;
import com.ak.patient_service.service.AllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/allergies")
@RequiredArgsConstructor
public class AllergyController {

    private final AllergyService allergyService;

    @PostMapping
    public ResponseEntity<AllergyDto> create(@Validated @RequestBody AllergyDto dto) {
        AllergyDto created = allergyService.create(dto);
        return ResponseEntity.created(URI.create("/api/allergies/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllergyDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(allergyService.getById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AllergyDto>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(allergyService.getByPatientId(patientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AllergyDto> update(@PathVariable Long id, @Validated @RequestBody AllergyDto dto) {
        return ResponseEntity.ok(allergyService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        allergyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
