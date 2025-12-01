package com.ak.patient_service.dto;

import com.ak.patient_service.model.Medication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    MedicationDto toDto(Medication medication);
    Medication toEntity(MedicationDto dto);
}
