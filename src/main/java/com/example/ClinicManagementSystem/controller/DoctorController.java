package com.example.ClinicManagementSystem.controller;

import com.example.ClinicManagementSystem.model.Doctor;
import com.example.ClinicManagementSystem.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable int id){
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/doctor")
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor){
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(savedDoctor.getId());
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable int id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok().build();
    }
}
