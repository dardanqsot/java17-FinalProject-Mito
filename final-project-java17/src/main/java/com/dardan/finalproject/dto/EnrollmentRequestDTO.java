package com.dardan.finalproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequestDTO {

    @NotNull
    private Integer idStudent;
    @NotNull
    private List<EnrollmentDetailRequestDTO> enrollmentDetails;
    @NotNull
    private boolean active;
}
