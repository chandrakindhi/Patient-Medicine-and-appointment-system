package com.example.Medicine.And.Appointment.System.controller;

import com.example.Medicine.And.Appointment.System.model.Appointment;
import com.example.Medicine.And.Appointment.System.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentService;

    @MockBean
    private RedirectAttributes redirectAttributes;

    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        appointment = new Appointment();
        appointment.setDoctorName("Dr. Smith");
    }

    @Test
    public void testBookAppointment() throws Exception {
        mockMvc.perform(post("/appointments/book")
                .param("doctorName", appointment.getDoctorName()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/medications"));

        ArgumentCaptor<Appointment> appointmentCaptor = ArgumentCaptor.forClass(Appointment.class);
        verify(appointmentService).bookAppointment(appointmentCaptor.capture());
        assert appointmentCaptor.getValue().getDoctorName().equals("Dr. Smith");
    }
}
