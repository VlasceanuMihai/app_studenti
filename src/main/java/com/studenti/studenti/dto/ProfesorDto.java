package com.studenti.studenti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto {

    @NotNull(message = "Nume cannot be null")
    private String nume;

    @NotNull(message = "Cnp cannot be null")
    private String cnp;
}
