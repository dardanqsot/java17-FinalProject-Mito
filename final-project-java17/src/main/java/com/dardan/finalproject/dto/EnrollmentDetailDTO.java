package com.dardan.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetailDTO {

    private Integer idEnrollment;

    private CourseDTO courseDTO;

    private String classroom;
}
