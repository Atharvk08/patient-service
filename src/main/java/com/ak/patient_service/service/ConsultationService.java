package com.ak.patient_service.service;

import com.ak.patient_service.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {
    ConsultationDto create(ConsultationDto dto);

    ConsultationDto getById(Long id);

    List<ConsultationDto> getByPatient(Long patientId);

    void delete(Long id);
}
