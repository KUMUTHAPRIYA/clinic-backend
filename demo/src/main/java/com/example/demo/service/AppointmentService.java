package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepo;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment save(Appointment appointment) {

        Long doctorId = appointment.getDoctor().getId();

        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }
}