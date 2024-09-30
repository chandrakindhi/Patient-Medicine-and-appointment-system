package com.example.Medicine.And.Appointment.System.service;

import com.example.Medicine.And.Appointment.System.model.Patient;
import com.example.Medicine.And.Appointment.System.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@AutoConfigureMockMvc
public class PatientServiceTest {

    @MockBean
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testRegisterPatient() {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setContactDetails("1234567890");
        patient.setMedicalHistory("No known allergies");

        patientService.registerPatient(patient);
        verify(patientRepository).save(patient);
    }
}
