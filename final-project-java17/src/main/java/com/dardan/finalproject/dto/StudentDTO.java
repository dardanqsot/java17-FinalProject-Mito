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
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 100, message = "firstName min 2 max 100")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 100, message = "lastName min 2 max 100")
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8, message = "dni is 8")
    private String dni;

    @NotNull
    private int age;
}
