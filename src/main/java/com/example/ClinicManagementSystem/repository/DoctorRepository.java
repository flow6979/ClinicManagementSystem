package com.example.ClinicManagementSystem.repository;

import com.example.ClinicManagementSystem.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}