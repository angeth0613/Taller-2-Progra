package co.edu.uptc.clinica.service;

import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.repository.PatientRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PatientService {

	
	private PatientRepository patientRepository;

	
	public PatientService() {
		this.patientRepository = new PatientRepository();
	}

	
	private boolean validate(Patient patient) {
		if (Objects.isNull(patient.getFirstName()) || patient.getFirstName().trim().isEmpty()) {
			return false;
		}
		if (Objects.isNull(patient.getLastName()) || patient.getLastName().trim().isEmpty()) {
			return false;
		}
		if (Objects.isNull(patient.getEmail()) || patient.getEmail().trim().isEmpty()) {
			return false;
		}
		if (Objects.isNull(patient.getIdentificationType())) {
			return false;
		}
		if (Objects.isNull(patient.getIdPatient()) || patient.getIdPatient() <= 0) {
			return false;
		}
		return true;
	}

	
	public boolean existsById(int i) {
		return !Objects.isNull(patientRepository.findById(i));
	}

	
	public boolean existsByEmail(String email) {
		return !Objects.isNull(patientRepository.findByEmail(email));
	}

	
	public boolean addPatient(Patient patient) {
		if (!validate(patient)) {
			return false;
		}
		if (existsById(patient.getIdPatient())) {
			return false;
		}
		if (existsByEmail(patient.getEmail())) {
			return false;
		}
		return this.patientRepository.addPatient(patient);
	}

	public Set<Patient> findAll() {
		return this.patientRepository.findAll();
	}

	
	public Patient findById(Long idPatient) {
		return this.patientRepository.findById(idPatient);
	}

	
	public boolean addMedication(Long idPatient, String medication) {
		if (Objects.isNull(patientRepository.findById(idPatient))) {
			return false;
		}
		return this.patientRepository.addMedicationToPatient(idPatient, medication);
	}


	public List<Patient> findAllOrderedByPriority() {
		List<Patient> list = new ArrayList<>(this.patientRepository.findAll());
		list.sort(Comparator.comparingInt(p -> -p.getPriority().getValue()));
		return list;
	}
}
