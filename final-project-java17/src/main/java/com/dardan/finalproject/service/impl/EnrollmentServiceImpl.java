package com.dardan.finalproject.service.impl;

import com.dardan.finalproject.model.Enrollment;
import com.dardan.finalproject.repo.IEnrollmentRepo;
import com.dardan.finalproject.repo.IGenericRepo;
import com.dardan.finalproject.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }
}
