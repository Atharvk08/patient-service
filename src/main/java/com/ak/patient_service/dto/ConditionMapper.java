package com.ak.patient_service.dto;

import com.ak.patient_service.model.Condition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConditionMapper {
    ConditionDto toDto(Condition condition);
    Condition toEntity(ConditionDto dto);
}
