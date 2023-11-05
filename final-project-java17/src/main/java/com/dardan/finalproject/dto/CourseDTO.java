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
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50, message = "name min 3")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10, message = "code min 3")
    private String code;

    @NotNull
    private boolean active;
}
