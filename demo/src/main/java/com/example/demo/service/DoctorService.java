package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepo;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepo.save(doctor);
    }
    public List<Doctor> getAllDoctor(){
        return doctorRepo.findAll();
    }

}
