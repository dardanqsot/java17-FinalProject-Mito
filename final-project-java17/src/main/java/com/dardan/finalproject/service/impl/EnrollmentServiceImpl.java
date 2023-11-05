package com.dardan.finalproject.service.impl;

import com.dardan.finalproject.dto.EnrollmentRequestDTO;
import com.dardan.finalproject.model.Course;
import com.dardan.finalproject.model.Enrollment;
import com.dardan.finalproject.model.EnrollmentDetail;
import com.dardan.finalproject.model.Student;
import com.dardan.finalproject.repo.*;
import com.dardan.finalproject.service.ICourseService;
import com.dardan.finalproject.service.IEnrollmentService;
import com.dardan.finalproject.service.IStudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    private final IEnrollmentDetailRepo enrollmentDetailRepo;

    private final ICourseService serviceCourse;
    private final IStudentService serviceStudent;

    private final ModelMapper mapper;
    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    @Transactional
    public void createEnrollment(EnrollmentRequestDTO enrollmentRequestDTO) {

        Enrollment enrollment = Enrollment.builder()
                .idStudent(enrollmentRequestDTO.getIdStudent())
                .enrollmentDate(LocalDateTime.now())
                .active(enrollmentRequestDTO.isActive())
                .build();
        List<EnrollmentDetail> enrollmentDetailList = enrollmentRequestDTO.getEnrollmentDetails().stream()
                .map(enrollmentDetail -> mapper.map(enrollmentDetail, EnrollmentDetail.class))
                .collect(Collectors.toList());
        enrollmentDetailRepo.saveAll(enrollmentDetailList);
        repo.save(enrollment);
    }



    @Override
    public Enrollment getEnrollmentById(Integer enrollmentId) {
        return repo.findById(enrollmentId).orElse(null);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return repo.findAll();
    }


    @Override
    public Map<String, List<String>> getCoursesAndStudents() throws Exception {
        List<Enrollment> enrollments = repo.findAll();
        Map<String, List<String>> courseStudentMap = new HashMap<>();
        Student student;
        String studentName;
        System.out.println("enrollments: "  + enrollments.size());
        for (Enrollment enrollment : enrollments)
        {
            student = serviceStudent.readById(enrollment.getIdStudent());
            studentName = student.getFirstName() + " " + student.getLastName();
            List<EnrollmentDetail> enrollmentsDetail  = enrollmentDetailRepo.findByIdEnrollment(enrollment.getIdEnrollment());
            System.out.println("enrollmentsDetail: "  + enrollmentsDetail.size());

            Course course;
            for(EnrollmentDetail enrollmentDetail:  enrollmentsDetail){
                course = serviceCourse.readById(enrollmentDetail.getIdCourse());
                courseStudentMap.computeIfAbsent(course.getName(), k -> new ArrayList<>()).add(studentName);
            }
        }

        return courseStudentMap;
    }
}
