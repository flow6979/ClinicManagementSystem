package com.example.ClinicManagementSystem.controller;

import com.example.ClinicManagementSystem.model.Patient;
import com.example.ClinicManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<?> getPatient(@PathVariable int id){
        Optional<Patient> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/patient")
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient){
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient.getId());
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
