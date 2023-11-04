package com.dardan.finalproject.service.impl;

import com.dardan.finalproject.model.Course;
import com.dardan.finalproject.repo.ICourseRepo;
import com.dardan.finalproject.repo.IGenericRepo;
import com.dardan.finalproject.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}
