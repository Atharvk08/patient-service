package com.ak.patient_service.service;

import com.ak.patient_service.dto.ConditionDto;
import com.ak.patient_service.dto.ConditionMapper;
import com.ak.patient_service.model.Condition;
import com.ak.patient_service.repository.ConditionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {

    private final ConditionRepository conditionRepository;
    private final ConditionMapper conditionMapper;

    @Override
    public ConditionDto create(ConditionDto dto) {
        Condition condition = conditionMapper.toEntity(dto);
        return conditionMapper.toDto(conditionRepository.save(condition));
    }

    @Override
    public ConditionDto getById(Long id) {
        Condition condition = conditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Condition not found: " + id));
        return conditionMapper.toDto(condition);
    }

    @Override
    public List<ConditionDto> getByPatient(Long patientId) {
        return conditionRepository.findByPatientId(patientId)
                .stream()
                .map(conditionMapper::toDto)
                .toList();
    }

    @Override
    public ConditionDto update(Long id, ConditionDto dto) {
        Condition existing = conditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Condition not found: " + id));

        existing.setName(dto.getName());
        existing.setClinicalStatus(dto.getClinicalStatus());
        existing.setOnsetDate(dto.getOnsetDate());
        existing.setSource(dto.getSource());

        return conditionMapper.toDto(conditionRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!conditionRepository.existsById(id)) {
            throw new EntityNotFoundException("Condition not found: " + id);
        }
        conditionRepository.deleteById(id);
    }
}
