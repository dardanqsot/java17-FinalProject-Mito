package com.dardan.finalproject.repo;

import com.dardan.finalproject.model.Student;

import java.util.List;

public interface IStudentRepo extends IGenericRepo<Student, Integer> {

    List<Student> findByFirstName(String name);
    List<Student> findByFirstNameLike(String name);
}
