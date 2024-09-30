package com.example.Medicine.And.Appointment.System.service;

import com.example.Medicine.And.Appointment.System.model.Medication;
import com.example.Medicine.And.Appointment.System.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;

    public List<Medication> getMedicationsByPatient(Long patientId) {
        return medicationRepository.findAll(); // Add logic to filter by patient
    }

    public void addMedication(Medication medication) {
        medicationRepository.save(medication);
    }
}
