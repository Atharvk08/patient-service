package com.ak.patient_service.service;

import com.ak.patient_service.dto.AllergyDto;

import java.util.List;

public interface AllergyService {

    AllergyDto create(AllergyDto dto);

    AllergyDto getById(Long id);

    List<AllergyDto> getByPatientId(Long patientId);

    AllergyDto update(Long id, AllergyDto dto);

    void delete(Long id);
}
