package com.ak.patient_service.service;

import com.ak.patient_service.dto.ConditionDto;

import java.util.List;

public interface ConditionService {

    ConditionDto create(ConditionDto dto);

    ConditionDto getById(Long id);

    List<ConditionDto> getByPatient(Long patientId);

    ConditionDto update(Long id, ConditionDto dto);

    void delete(Long id);
}
