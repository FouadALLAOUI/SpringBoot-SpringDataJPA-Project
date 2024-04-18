package com.fouad.exemple.student;


import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
    @NotEmpty
    String firstname,
    @NotEmpty
    String lastname,
    @NotEmpty
    String email,
    Integer schoolId
) {



}
