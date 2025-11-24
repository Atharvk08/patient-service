package com.ak.patient_service.dto;

import com.ak.patient_service.model.Consultation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {
    ConsultationDto toDto(Consultation consultation);
    Consultation toEntity(ConsultationDto dto);
}
