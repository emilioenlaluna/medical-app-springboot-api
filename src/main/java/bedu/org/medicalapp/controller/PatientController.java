package bedu.org.medicalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bedu.org.medicalapp.dto.CreatePatientDTO;
import bedu.org.medicalapp.dto.PatientDTO;
import bedu.org.medicalapp.dto.UpdatePatientDTO;
import bedu.org.medicalapp.exception.PatientNotFoundException;
import bedu.org.medicalapp.service.PatientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PatientDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDTO save(@Valid @RequestBody CreatePatientDTO data ){
        return service.save(data);
    }

    @PutMapping("{patientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long patientId,@RequestBody UpdatePatientDTO data) throws PatientNotFoundException{
        service.update(patientId,data);
    }

     @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

}
