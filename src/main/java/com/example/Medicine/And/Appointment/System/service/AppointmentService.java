package com.example.Medicine.And.Appointment.System.service;

import com.example.Medicine.And.Appointment.System.model.Appointment;
import com.example.Medicine.And.Appointment.System.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void bookAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
