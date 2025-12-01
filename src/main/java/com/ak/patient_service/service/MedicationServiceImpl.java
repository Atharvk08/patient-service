package com.ak.patient_service.service;

import com.ak.patient_service.dto.MedicationDto;
import com.ak.patient_service.dto.MedicationMapper;
import com.ak.patient_service.model.Consultation;
import com.ak.patient_service.model.Medication;
import com.ak.patient_service.repository.ConsultationRepository;
import com.ak.patient_service.repository.MedicationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final ConsultationRepository consultationRepository;
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    @Override
    public MedicationDto addMedication(Long consultationId, MedicationDto dto) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found: " + consultationId));

        Medication med = medicationMapper.toEntity(dto);
        consultation.getMedications().add(med);

        consultationRepository.save(consultation);
        return medicationMapper.toDto(med);
    }

    @Override
    public MedicationDto updateMedication(Long consultationId, Long medicationId, MedicationDto dto) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found: " + consultationId));

        Medication med = consultation.getMedications()
                .stream()
                .filter(m -> m.getId().equals(medicationId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Medication not found: " + medicationId));

        med.setName(dto.getName());
        med.setDosage(dto.getDosage());
        med.setDuration(dto.getDuration());
        med.setInstructions(dto.getInstructions());

        consultationRepository.save(consultation);

        return medicationMapper.toDto(med);
    }

    @Override
    public List<MedicationDto> listMedications(Long consultationId) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found: " + consultationId));

        return consultation.getMedications()
                .stream()
                .map(medicationMapper::toDto)
                .toList();
    }

    @Override
    public void deleteMedication(Long consultationId, Long medicationId) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found: " + consultationId));

        boolean removed = consultation.getMedications()
                .removeIf(m -> m.getId().equals(medicationId));

        if (!removed) {
            throw new EntityNotFoundException("Medication not found: " + medicationId);
        }

        consultationRepository.save(consultation);
    }
}
