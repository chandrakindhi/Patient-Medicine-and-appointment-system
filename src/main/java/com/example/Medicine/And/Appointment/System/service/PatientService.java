package com.example.Medicine.And.Appointment.System.service;

import com.example.Medicine.And.Appointment.System.model.Patient;
import com.example.Medicine.And.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void registerPatient(Patient patient) {
        patientRepository.save(patient);
    }

}
