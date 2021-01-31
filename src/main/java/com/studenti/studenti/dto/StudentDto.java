package com.studenti.studenti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @NotNull(message = "Nume cannot be null")
    private String nume;

    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @NotNull(message = "Cnp cannot be null")
    private String cnp;

    @NotNull
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 50, message = "Invalid length for email")
    public String email;
}
