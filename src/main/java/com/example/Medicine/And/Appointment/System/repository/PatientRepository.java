package com.example.Medicine.And.Appointment.System.repository;

import com.example.Medicine.And.Appointment.System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
