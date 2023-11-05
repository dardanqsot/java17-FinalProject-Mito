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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollmentDetail;

    @Column(nullable = false)
    private Integer idEnrollment;

    @Column(nullable = false)
    private Integer idCourse;

    @Column(length = 50, nullable = false)
    private String classroom;


}
