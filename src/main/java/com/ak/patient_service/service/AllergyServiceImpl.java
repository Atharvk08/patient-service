package com.ak.patient_service.service;

import com.ak.patient_service.dto.AllergyDto;
import com.ak.patient_service.dto.AllergyMapper;
import com.ak.patient_service.model.Allergy;
import com.ak.patient_service.repository.AllergyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllergyServiceImpl implements AllergyService {

    private final AllergyRepository allergyRepository;
    private final AllergyMapper allergyMapper;

    @Override
    public AllergyDto create(AllergyDto dto) {
        Allergy allergy = allergyMapper.toEntity(dto);
        return allergyMapper.toDto(allergyRepository.save(allergy));
    }

    @Override
    public AllergyDto getById(Long id) {
        Allergy allergy = allergyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Allergy not found: " + id));
        return allergyMapper.toDto(allergy);
    }

    @Override
    public List<AllergyDto> getByPatientId(Long patientId) {
        return allergyRepository.findByPatientId(patientId)
                .stream()
                .map(allergyMapper::toDto)
                .toList();
    }

    @Override
    public AllergyDto update(Long id, AllergyDto dto) {
        Allergy existing = allergyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Allergy not found: " + id));

        existing.setSubstanceCode(dto.getSubstanceCode());
        existing.setSubstanceName(dto.getSubstanceName());
        existing.setReaction(dto.getReaction());
        existing.setSeverity(dto.getSeverity());
        existing.setVerifiedByDoctorId(dto.getVerifiedByDoctorId());
        existing.setIsActive(dto.getIsActive());

        return allergyMapper.toDto(allergyRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!allergyRepository.existsById(id)) {
            throw new EntityNotFoundException("Allergy not found: " + id);
        }
        allergyRepository.deleteById(id);
    }
}
