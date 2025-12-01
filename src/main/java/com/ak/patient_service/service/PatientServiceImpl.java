package com.ak.patient_service.service;

import com.ak.patient_service.dto.PatientDto;
import com.ak.patient_service.dto.PatientMapper;
import com.ak.patient_service.model.Gender;
import com.ak.patient_service.model.Patient;
import com.ak.patient_service.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Override
    public PatientDto createPatient(PatientDto dto) {
        Patient patient = mapper.toEntity(dto);
        Patient saved = repository.save(patient);
        return mapper.toDto(saved);
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found!"));
        return mapper.toDto(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto dto) {
        Patient existing = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Patient not found!"));
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setDateOfBirth(dto.getDateOfBirth());
        existing.setGender(Gender.valueOf(dto.getGender()));
        existing.setPhone(dto.getPhone());
        existing.setEmail(dto.getEmail());
        existing.setAddress(dto.getAddress());
        existing.setEmergencyContact(dto.getEmergencyContact());

        Patient updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void deletePatient(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Patient not found: " + id);
        }
        repository.deleteById(id);
    }
}
