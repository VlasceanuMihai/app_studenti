package com.studenti.studenti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEnrollRequest {

    @NotNull(message = "Nume student cannot be null")
    private String numeStudent;

    @NotNull(message = "Nume materie cannot be null")
    private String numeMaterie;
}
