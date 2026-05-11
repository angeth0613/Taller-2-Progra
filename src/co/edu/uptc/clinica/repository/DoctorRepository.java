package co.edu.uptc.clinica.repository;

import co.edu.uptc.clinica.domain.Doctor;

import java.util.HashSet;
import java.util.Set;


public class DoctorRepository {

	private Set<Doctor> doctors;

	public DoctorRepository() {
		this.doctors = new HashSet<>();
	}


	public boolean addDoctor(Doctor doctor) {
		return this.doctors.add(doctor);
	}

	
	public Set<Doctor> findAll() {
		return this.doctors;
	}

	
	public Doctor findById(Long medicalId) {
		return this.doctors.stream()
				.filter(d -> d.getMedicalId().equals(medicalId))
				.findFirst().orElse(null);
	}
}
