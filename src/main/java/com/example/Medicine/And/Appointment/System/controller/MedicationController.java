package com.example.Medicine.And.Appointment.System.controller;

import com.example.Medicine.And.Appointment.System.model.Medication;
import com.example.Medicine.And.Appointment.System.repository.MedicationRepository;
import com.example.Medicine.And.Appointment.System.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/medications")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @GetMapping
    public String viewMedications(Model model) {
        // Logic to fetch medications for a patient
        model.addAttribute("medications", medicationService.getMedicationsByPatient(1L)); // Example patient ID
        return "medications";
    }

    @PostMapping("/add")
    public String addMedication(@ModelAttribute Medication medication, RedirectAttributes redirectAttributes) {
        medicationService.addMedication(medication);
        redirectAttributes.addFlashAttribute("success", "Medication added successfully!");
        return "redirect:/medications";
    }
}
