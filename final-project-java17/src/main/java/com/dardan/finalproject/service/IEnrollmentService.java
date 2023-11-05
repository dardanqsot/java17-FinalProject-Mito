package com.dardan.finalproject.service;


import com.dardan.finalproject.dto.EnrollmentRequestDTO;
import com.dardan.finalproject.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer>{

    void createEnrollment(EnrollmentRequestDTO enrollment);
    Enrollment getEnrollmentById(Integer enrollmentId);
    List<Enrollment> getAllEnrollments();
    Map<String, List<String>> getCoursesAndStudents() throws Exception;

}
