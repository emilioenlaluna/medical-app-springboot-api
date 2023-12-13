package bedu.org.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bedu.org.medicalapp.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{

    
} 
