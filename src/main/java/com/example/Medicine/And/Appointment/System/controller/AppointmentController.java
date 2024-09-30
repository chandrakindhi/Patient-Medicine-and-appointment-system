package com.example.Medicine.And.Appointment.System.controller;


import com.example.Medicine.And.Appointment.System.model.Appointment;
import com.example.Medicine.And.Appointment.System.model.Patient;
import com.example.Medicine.And.Appointment.System.repository.AppointmentRepository;
import com.example.Medicine.And.Appointment.System.service.AppointmentService;
import com.example.Medicine.And.Appointment.System.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String viewAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute Appointment appointment, RedirectAttributes redirectAttributes) {
        appointment.setAppointmentDate(LocalDateTime.now()); // Set appointment date
        appointmentService.bookAppointment(appointment);
        redirectAttributes.addFlashAttribute("success", "Appointment booked successfully!");
        return "redirect:/medications";
    }
}
