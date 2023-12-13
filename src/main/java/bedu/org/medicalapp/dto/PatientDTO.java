package bedu.org.medicalapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PatientDTO {

    private long id;

    private String name;

    private String lastName;

    private String nss;

    private Date birthdate;

    private String email;

    private String address;

    private String phoneNumber;

}
