package bedu.org.medicalapp.exception;

public class PatientNotFoundException extends RuntimeException {
    
    public PatientNotFoundException(long id) {
        super("El paciente no existe", "ERR_PAC_NOT_FOUND", id);
    }
}
