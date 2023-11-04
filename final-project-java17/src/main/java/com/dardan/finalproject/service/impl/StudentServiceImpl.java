package com.dardan.finalproject.service.impl;

import com.dardan.finalproject.model.Student;
import com.dardan.finalproject.repo.IGenericRepo;
import com.dardan.finalproject.repo.IStudentRepo;
import com.dardan.finalproject.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    public List<Student> findByName(String name) {
        return repo.findByFirstName(name);
    }

    @Override
    public List<Student> findByNameLike(String name) {
        return repo.findByFirstNameLike("%" + name + "%");
    }

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

}
