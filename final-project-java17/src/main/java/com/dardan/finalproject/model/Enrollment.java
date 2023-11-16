package com.dardan.finalproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollment;

    private LocalDateTime enrollmentDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private  Student student;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentDetail> enrollmentDetails;

}
