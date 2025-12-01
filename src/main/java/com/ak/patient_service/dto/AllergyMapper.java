package com.ak.patient_service.dto;

import com.ak.patient_service.model.Allergy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AllergyMapper {
    AllergyDto toDto(Allergy allergy);
    Allergy toEntity(AllergyDto dto);
}
