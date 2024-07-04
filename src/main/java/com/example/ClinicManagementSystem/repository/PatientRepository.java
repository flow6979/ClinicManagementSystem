package com.example.ClinicManagementSystem.repository;

import com.example.ClinicManagementSystem.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}