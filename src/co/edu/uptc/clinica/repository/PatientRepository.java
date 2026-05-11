package co.edu.uptc.clinica.repository;
import co.edu.uptc.clinica.domain.Patient;
import java.util.HashSet;
import java.util.Set;


public class PatientRepository {

	private Set<Patient> patients;

	
	public PatientRepository() {
		this.patients = new HashSet<>();
	}

	
	public boolean addPatient(Patient patient) {
		return this.patients.add(patient);
	}

	
	public Set<Patient> findAll() {
		return this.patients;
	}

	
	public Patient findById(Long idPatient) {
		return this.patients.stream()
				.filter(p -> p.getIdPatient().equals(idPatient))
				.findFirst().orElse(null);
	}

	
	public Patient findByEmail(String email) {
		return this.patients.stream()
				.filter(p -> p.getEmail().equalsIgnoreCase(email))
				.findFirst().orElse(null);
	}

	
	public boolean addMedicationToPatient(Long idPatient, String medication) {
		Patient patient = findById(idPatient);
		if (patient != null) {
			return patient.getMedicationHistory().add(medication);
		}
		return false;
	}
}
