package com.example.Medicine.And.Appointment.System.service;

import com.example.Medicine.And.Appointment.System.model.Medication;
import com.example.Medicine.And.Appointment.System.repository.MedicationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@AutoConfigureMockMvc
public class MedicationServiceTest {

    @MockBean
    private MedicationRepository medicationRepository;

    @Autowired
    private MedicationService medicationService;

    @Test
    public void testAddMedication() {
        Medication medication = new Medication();
        medication.setName("Aspirin");
        medication.setDosage("100mg");

        medicationService.addMedication(medication);
        verify(medicationRepository).save(medication);
    }
}
