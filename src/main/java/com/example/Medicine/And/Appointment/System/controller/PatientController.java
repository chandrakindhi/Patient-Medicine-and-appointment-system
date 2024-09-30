package com.example.Medicine.And.Appointment.System.controller;


import com.example.Medicine.And.Appointment.System.model.Patient;
import com.example.Medicine.And.Appointment.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String registerPatient(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {
        patientService.registerPatient(patient);
        redirectAttributes.addFlashAttribute("success", "Registration successful!");
        return "redirect:/appointments";
    }
}
