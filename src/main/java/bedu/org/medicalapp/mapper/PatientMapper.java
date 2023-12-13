package bedu.org.medicalapp.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import bedu.org.medicalapp.dto.CreatePatientDTO;
import bedu.org.medicalapp.dto.PatientDTO;
import bedu.org.medicalapp.dto.UpdatePatientDTO;
import bedu.org.medicalapp.model.Patient;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface PatientMapper {

    PatientDTO toDTO(Patient model);

    List<PatientDTO> toDTO(List<Patient>model);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Patient toModel(CreatePatientDTO data);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "medicalRecordId", target = "medicalRecord.id")
    Patient toModel(CreatePatientDTO dto, Long medicalRecordId);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(@MappingTarget Patient model, UpdatePatientDTO dto);

} 