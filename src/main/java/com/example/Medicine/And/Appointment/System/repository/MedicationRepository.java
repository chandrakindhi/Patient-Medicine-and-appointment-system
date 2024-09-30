package com.example.Medicine.And.Appointment.System.repository;

import com.example.Medicine.And.Appointment.System.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
