package com.dardan.finalproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EnrollmentDetail {

    @Id
    private Integer idEnrollment;

    @ManyToOne
    private Course course;
    private String classroom;


}
