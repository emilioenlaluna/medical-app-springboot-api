
package bedu.org.medicalapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import bedu.org.medicalapp.dto.CreatePatientDTO;
import bedu.org.medicalapp.dto.PatientDTO;
import bedu.org.medicalapp.service.PatientService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PatientControllerTest {
    @Autowired
    private PatientController controller;

    @MockBean
    private PatientService service;

    @Test
    @DisplayName("controller should be injected")
    public void smokeTest() {
        assertNotNull(controller);
    }

    @Test
    @DisplayName("Controller should return a list of interviewers")
    public void findAllTest() {
        // Arrange
        List<PatientDTO> fakeData = new LinkedList<>();

        PatientDTO fakepatient = new PatientDTO();

        fakepatient.setId(100);
        fakepatient.setName("Joaquin Salazar");
        fakepatient.setEmail("joaquin@test.com");

        fakeData.add(fakepatient);

        when(service.findAll()).thenReturn(fakeData);

        // Act
        List<PatientDTO> result = controller.findAll();

        // Assert
        assertEquals(fakeData, result);
    }



    @Test
    @DisplayName("")
    public void saveTest(){
        CreatePatientDTO dto =new CreatePatientDTO();
        dto.setName("Emilio");
        dto.setEmail("emilioenlaluna@gmail.com");
        
        PatientDTO saved=new PatientDTO();
        saved.setId(1);
        saved.setName("Emilio");
        saved.setEmail("emilioenlaluna@gmail.com");
        
        when(service.save(any(CreatePatientDTO.class))).thenReturn(saved);
        PatientDTO result =controller.save(dto);

        assertNotNull(result);
        assertEquals(dto.getEmail(), result.getEmail());
        assertEquals(dto.getName(), result.getName());
        }

}