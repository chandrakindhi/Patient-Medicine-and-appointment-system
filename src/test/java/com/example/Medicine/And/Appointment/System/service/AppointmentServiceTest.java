package com.example.Medicine.And.Appointment.System.service;

import com.example.Medicine.And.Appointment.System.model.Appointment;
import com.example.Medicine.And.Appointment.System.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@AutoConfigureMockMvc
public class AppointmentServiceTest {

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testBookAppointment() {
        Appointment appointment = new Appointment();
        appointment.setDoctorName("Dr. Smith");

        appointmentService.bookAppointment(appointment);
        verify(appointmentRepository).save(appointment);
    }
}
