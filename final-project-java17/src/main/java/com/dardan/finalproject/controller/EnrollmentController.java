package com.dardan.finalproject.controller;


import com.dardan.finalproject.dto.EnrollmentDTO;
import com.dardan.finalproject.dto.EnrollmentRequestDTO;
import com.dardan.finalproject.model.Enrollment;
import com.dardan.finalproject.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    private final ModelMapper mapper;
    @PostMapping
    public ResponseEntity<Void> createEnrollment(@RequestBody EnrollmentRequestDTO enrollmentDTO) {
        service.createEnrollment(enrollmentDTO);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentDTO> getEnrollment(@PathVariable Integer enrollmentId) {
        EnrollmentDTO enrollmentDto = convertToDto(service.getEnrollmentById(enrollmentId))     ;
        return new ResponseEntity<>(enrollmentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        List<EnrollmentDTO> enrollments = service.getAllEnrollments()
                .stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/courses/enrollments")
    public ResponseEntity<Map<String, List<String>>> getCoursesAndStudents() throws Exception{
        Map<String, List<String>> courseStudentMap = service.getCoursesAndStudents();
        return new ResponseEntity<>(courseStudentMap, HttpStatus.OK);
    }

    private EnrollmentDTO convertToDto(Enrollment obj){
        return mapper.map(obj, EnrollmentDTO.class);
    }

    private Enrollment convertToEntity(EnrollmentDTO dto){
        return mapper.map(dto, Enrollment.class);
    }
}
