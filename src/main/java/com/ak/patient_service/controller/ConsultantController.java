package com.ak.patient_service.controller;

import com.ak.patient_service.dto.ConsultationDto;
import com.ak.patient_service.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/consultations")
public class ConsultantController {
    private final ConsultationService service;

    @PostMapping
    public ResponseEntity<ConsultationDto> create(@Validated @RequestBody ConsultationDto dto) {
        ConsultationDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/consultations/" +created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationDto> getById(@PathVariable Long id){
        ConsultationDto found = service.getById(id);
        return ResponseEntity.ok(found);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ConsultationDto>> getByPatient(@PathVariable Long patientId){
        return ResponseEntity.ok(service.getByPatient(patientId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
