package com.fouad.exemple.student;


import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
    @NotEmpty(message = "Firstname should not be empty")
    String firstname,
    @NotEmpty(message = "Lastname should not be empty")
    String lastname,
    @NotEmpty
    String email,
    Integer schoolId
) {



}
