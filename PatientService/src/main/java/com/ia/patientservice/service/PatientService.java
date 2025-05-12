package com.ia.patientservice.service;


// business logic and dto conversion happens

import com.ia.patientservice.dto.PatientResponseDTO;
import com.ia.patientservice.mapper.PatientMapper;
import com.ia.patientservice.model.Patient;
import com.ia.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    // dependency injection
    public PatientService(PatientRepository patientRepository) {
     this.patientRepository = patientRepository;
 }

    public List<PatientResponseDTO> getPatients () {
        List<Patient> patients = patientRepository.findAll();
        // logic to now convert each of the patients to a DTO object


        //  return patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }
}
