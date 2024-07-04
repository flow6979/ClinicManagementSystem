package com.example.ClinicManagementSystem.service;

import com.example.ClinicManagementSystem.model.Doctor;
import com.example.ClinicManagementSystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> getDoctorById(int id){
        return doctorRepository.findById(id);
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id){
        doctorRepository.deleteById(id);
    }
}