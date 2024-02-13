package com.example.rh.Models.Dtos.Request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HrAdministrationRequestDTO {
    @NotBlank(message = "CIN is mandatory")
    private String cin;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "First name is mandatory")
    private String firstname;

    @NotBlank(message = "Last name is mandatory")
    private String lastname;

    @NotNull(message = "Company ID is mandatory")
    private Long companyId;

    @NotNull(message = "General Administration ID is mandatory")
    private Long generalAdministrationId;

}
