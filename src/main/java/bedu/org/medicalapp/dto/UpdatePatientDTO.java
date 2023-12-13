package bedu.org.medicalapp.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UpdatePatientDTO {
     @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String nss;

    @NotBlank
    private Date birthdate;

    @Email
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;
}
