package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
@RequestMapping("/appointments")

public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAppointments(){
        return appointmentService.getAllAppointments();
    }
    
}
