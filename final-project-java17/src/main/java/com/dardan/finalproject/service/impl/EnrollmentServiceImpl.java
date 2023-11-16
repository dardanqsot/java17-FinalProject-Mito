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
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    private final IEnrollmentDetailRepo enrollmentDetailRepo;

    private final ModelMapper mapper;
    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    @Transactional
    public void createEnrollment(EnrollmentRequestDTO enrollmentRequestDTO) {

        Enrollment enrollment = Enrollment.builder()
                //.idStudent(enrollmentRequestDTO.getIdStudent())
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
    public Map<String, List<String>> getCoursesAndStudents() {
        Stream<Enrollment> enrollStream=repo.findAll().stream();
        Stream<List<EnrollmentDetail>> lsEnrollDetailStream = enrollStream.map(Enrollment::getEnrollmentDetails);
        Stream<EnrollmentDetail> enrollDetailStream =  lsEnrollDetailStream.flatMap(list-> list.stream());
        Map<String, List<String>> studentsByCourse = enrollDetailStream.collect(Collectors.groupingBy(s->s.getCourse().getName(), Collectors.mapping(t->t.getEnrollment().getStudent().getName()+" "+t.getEnrollment().getStudent().getLastName(), Collectors.toList())));
        return studentsByCourse;
    }


}
