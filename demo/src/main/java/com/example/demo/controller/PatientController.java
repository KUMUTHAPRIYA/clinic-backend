package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("patients")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient savePatients(@RequestBody Patient patient){
       return patientService.savPatient(patient);
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getAllPatients();
    }
}
