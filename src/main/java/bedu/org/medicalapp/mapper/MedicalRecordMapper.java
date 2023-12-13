package bedu.org.medicalapp.mapper;

import bedu.org.medicalapp.dto.MedicalRecordDTO;
import bedu.org.medicalapp.model.MedicalRecord;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MedicalRecordMapper {
    
    MedicalRecordDTO toDTO(MedicalRecord model);
}