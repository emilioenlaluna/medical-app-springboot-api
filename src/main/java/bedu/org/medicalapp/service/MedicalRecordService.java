package bedu.org.medicalapp.service;

import bedu.org.medicalapp.dto.MedicalRecordDTO;
import bedu.org.medicalapp.mapper.MedicalRecordMapper;
import bedu.org.medicalapp.model.MedicalRecord;
import bedu.org.medicalapp.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    
    @Autowired
    private MedicalRecordRepository repository;

    @Autowired
    private MedicalRecordMapper mapper;

    public MedicalRecordDTO save() {
        MedicalRecord model = new MedicalRecord();
        MedicalRecord entity = repository.save(model);
        return mapper.toDTO(entity);
    }
}