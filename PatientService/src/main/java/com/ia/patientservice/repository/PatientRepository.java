package com.ia.patientservice.repository;


import com.ia.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


// create a patient repository that extends the jpa repository package and pass in the object it needs to control
// and the type of its ID
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // extend the functionality that jpa has given us
    boolean existsByEmail(String Email); // expose this function to our service
    boolean existsByEmailAndIdNot(String Email, UUID id); // seach db for emails except for the current patient
}
