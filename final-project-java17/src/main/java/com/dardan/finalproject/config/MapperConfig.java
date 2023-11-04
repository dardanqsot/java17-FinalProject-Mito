package com.dardan.finalproject.config;


import com.dardan.finalproject.dto.StudentDTO;
import com.dardan.finalproject.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper StudentMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<Student, StudentDTO> typeMap1 = mapper.createTypeMap(Student.class, StudentDTO.class);
        return mapper;
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}
