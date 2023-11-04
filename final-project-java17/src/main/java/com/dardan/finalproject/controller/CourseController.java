package com.dardan.finalproject.controller;

import com.dardan.finalproject.service.ICourseService;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

}
