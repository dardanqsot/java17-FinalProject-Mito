package com.dardan.finalproject.controller;

import com.dardan.finalproject.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

}
