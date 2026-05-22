package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {
      @Autowired
      private DoctorService doctorService;
      
      @PostMapping
      public Doctor addDocter(@RequestBody Doctor doctor){
            return doctorService.saveDoctor(doctor);
      }

      @GetMapping
      public List<Doctor> getDoctors(){
        return doctorService.getAllDoctor();
      }
    
}
