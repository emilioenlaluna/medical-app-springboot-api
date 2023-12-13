package bedu.org.medicalapp.dto;

import java.util.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreatePatientDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String nss;

    @NotBlank
    private Date birthdate;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;
}
