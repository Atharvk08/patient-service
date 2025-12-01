package com.ak.patient_service.controller;

import com.ak.patient_service.dto.ConditionDto;
import com.ak.patient_service.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/conditions")
@RequiredArgsConstructor
public class ConditionController {

    private final ConditionService conditionService;

    @PostMapping
    public ResponseEntity<ConditionDto> create(@Validated @RequestBody ConditionDto dto) {
        ConditionDto created = conditionService.create(dto);
        return ResponseEntity.created(URI.create("/api/conditions/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConditionDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(conditionService.getById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ConditionDto>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(conditionService.getByPatient(patientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConditionDto> update(@PathVariable Long id, @Validated @RequestBody ConditionDto dto) {
        return ResponseEntity.ok(conditionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        conditionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

