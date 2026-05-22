package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Review;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    // Save Review
    public Review save(Review review) {

        Long doctorId = review.getDoctor().getId();

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        review.setDoctor(doctor);

        return reviewRepo.save(review);
    }

    // Get All Reviews
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }
}