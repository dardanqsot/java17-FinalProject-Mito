package com.dardan.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {

    private Integer id;
    private LocalDateTime enrollmentDate;
    private StudentDTO student;
    private List<EnrollmentDetailDTO> enrollmentDetails;
    private boolean active;
}
