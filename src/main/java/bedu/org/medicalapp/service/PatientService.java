package bedu.org.medicalapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bedu.org.medicalapp.dto.CreatePatientDTO;
import bedu.org.medicalapp.dto.MedicalRecordDTO;
import bedu.org.medicalapp.dto.PatientDTO;
import bedu.org.medicalapp.dto.UpdatePatientDTO;
import bedu.org.medicalapp.exception.PatientNotFoundException;
import bedu.org.medicalapp.mapper.PatientMapper;
import bedu.org.medicalapp.model.Patient;
import bedu.org.medicalapp.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientMapper mapper;

    @Autowired
    private PatientRepository repository;

    @Autowired
    private MedicalRecordService medicalRecordService;

    public List<PatientDTO> findAll(){
        List<Patient>data=repository.findAll();
        return mapper.toDTO(data);
    }


     @Transactional
    public PatientDTO save(CreatePatientDTO data) {

        MedicalRecordDTO medicalRecord = medicalRecordService.save();

        Patient model = mapper.toModel(data, medicalRecord.getId());

        Patient result = repository.save(model);
        
        return mapper.toDTO(result);
    }

    /*
     * 
     * 

     @Transactional
    public PatientDTO save(CreatePatientDTO data) {

        MedicalRecordDTO medicalRecord = medicalRecordService.save();

        Patient model = mapper.toModel(data);

        MedicalRecord medicalRecordModel= new MedicalRecord();
        medicalRecordModel.setId(medicalRecord.getId());

        model.setMedicalRecord(medicalRecordModel);

        Patient result = repository.save(model);
        
        return mapper.toDTO(result);
    }
     */


    public void update(long patientId,UpdatePatientDTO data) throws PatientNotFoundException{
 Optional<Patient> result = repository.findById(patientId);

  if (result.isEmpty()) {
            throw new PatientNotFoundException(patientId);
        }

         Patient model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
