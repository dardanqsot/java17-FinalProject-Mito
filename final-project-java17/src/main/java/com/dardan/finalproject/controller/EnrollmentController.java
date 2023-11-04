package com.dardan.finalproject.controller;


import com.dardan.finalproject.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;



}
