package com.dardan.finalproject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetailRequestDTO {

    @NotNull
    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 50, message = "classroom min 10")
    private String classroom;
}
