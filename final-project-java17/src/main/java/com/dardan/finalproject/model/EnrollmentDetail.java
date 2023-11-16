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


    @ManyToOne
    @JoinColumn(nullable = false)
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Course course;


    @Column(length = 50, nullable = false)
    private String classroom;


}
