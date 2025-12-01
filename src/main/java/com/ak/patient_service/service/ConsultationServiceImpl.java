package com.ak.patient_service.service;

import com.ak.patient_service.dto.ConsultationDto;
import com.ak.patient_service.dto.ConsultationMapper;
import com.ak.patient_service.model.Consultation;
import com.ak.patient_service.repository.ConsultationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final ConsultationMapper consultationMapper;

    @Override
    public ConsultationDto create(ConsultationDto dto) {
        Consultation consultation = consultationMapper.toEntity(dto);
        Consultation saved = consultationRepository.save(consultation);
        return consultationMapper.toDto(saved);
    }

    @Override
    public ConsultationDto getById(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found: " + id));
        return consultationMapper.toDto(consultation);
    }

    @Override
    public List<ConsultationDto> getByPatient(Long patientId) {
        return consultationRepository.findByPatientId(patientId)
                .stream()
                .map(consultationMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!consultationRepository.existsById(id)) {
            throw new EntityNotFoundException("Consultation not found: " + id);
        }
        consultationRepository.deleteById(id);
    }
}

