package com.example.Medicine.And.Appointment.System.controller;

import com.example.Medicine.And.Appointment.System.model.Patient;
import com.example.Medicine.And.Appointment.System.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @MockBean
    private RedirectAttributes redirectAttributes;

    private Patient patient;

    @BeforeEach
    public void setUp() {
        patient = new Patient();
        patient.setName("John Doe");
        patient.setContactDetails("1234567890");
        patient.setMedicalHistory("No known allergies");
    }

    @Test
    public void testRegisterPatient() throws Exception {
        mockMvc.perform(post("/patients/register")
                .param("name", patient.getName())
                .param("contactDetails", patient.getContactDetails())
                .param("medicalHistory", patient.getMedicalHistory()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/appointments"));

        ArgumentCaptor<Patient> patientCaptor = ArgumentCaptor.forClass(Patient.class);
        verify(patientService).registerPatient(patientCaptor.capture());
        assert patientCaptor.getValue().getName().equals("John Doe");
    }
}
