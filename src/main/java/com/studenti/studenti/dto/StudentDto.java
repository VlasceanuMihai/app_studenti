package com.studenti.studenti.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class StudentDto {

    @NotNull(message = "Nume cannot be null")
    private String nume;

    @NotNull(message = "Nume cannot be null")
    private String prenume;

    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @NotNull(message = "Nume cannot be null")
    private String cnp;

    @NotNull
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 50, message = "Invalid length for email")
    public String email;
}
