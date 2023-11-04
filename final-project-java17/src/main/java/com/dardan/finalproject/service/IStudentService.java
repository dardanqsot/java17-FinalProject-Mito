package com.dardan.finalproject.service;

import com.dardan.finalproject.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer>{
    List<Student> findByName(String name);
    List<Student> findByNameLike(String name);

}
