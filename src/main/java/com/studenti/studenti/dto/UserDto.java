package com.studenti.studenti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "First name cannot be null")
    @NotEmpty
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @Email(message = "Email should be valid")
    @Size(min = 3, max = 50, message = "Invalid length for email")
    private String email;

    @NotNull(message = "Password should be valid")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    private String password;

    @NotNull(message = "Password should be valid")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    private String matchingPassword;

}
