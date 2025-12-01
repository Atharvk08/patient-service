package com.ak.patient_service.service;

import com.ak.patient_service.dto.MedicationDto;

import java.util.List;

public interface MedicationService {

    MedicationDto addMedication(Long consultationId, MedicationDto dto);

    MedicationDto updateMedication(Long consultationId, Long medicationId, MedicationDto dto);

    List<MedicationDto> listMedications(Long consultationId);

    void deleteMedication(Long consultationId, Long medicationId);
}
