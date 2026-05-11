package co.edu.uptc.clinica.service;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class DoctorService {

	private DoctorRepository doctorRepository;

	
	public DoctorService() {
		this.doctorRepository = new DoctorRepository();
	}

	
	private boolean validate(Doctor doctor) {
		if (Objects.isNull(doctor.getFirstName()) || doctor.getFirstName().trim().isEmpty()) {
			return false;
		}
		if (Objects.isNull(doctor.getLastName()) || doctor.getLastName().trim().isEmpty()) {
			return false;
		}
		if (Objects.isNull(doctor.getSpecialty()) || doctor.getSpecialty().trim().isEmpty()) {
			return false;
		}
		if (Objects.isNull(doctor.getIdentificationType())) {
			return false;
		}
		if (Objects.isNull(doctor.getMedicalId()) || doctor.getMedicalId() <= 0) {
			return false;
		}
		if (Objects.isNull(doctor.getYearsOfExperience()) || doctor.getYearsOfExperience() < 0) {
			return false;
		}
		return true;
	}

	
	public boolean existsById(Long medicalId) {
		return !Objects.isNull(doctorRepository.findById(medicalId));
	}

	
	public boolean addDoctor(Doctor doctor) {
		if (!validate(doctor)) {
			return false;
		}
		if (existsById(doctor.getMedicalId())) {
			return false;
		}
		return this.doctorRepository.addDoctor(doctor);
	}

	
	public Set<Doctor> findAll() {
		return this.doctorRepository.findAll();
	}

	
	public Doctor findById(Long medicalId) {
		return this.doctorRepository.findById(medicalId);
	}

	
	
	public List<Doctor> findAllOrderedByExperience() {
		List<Doctor> list = new ArrayList<>(this.doctorRepository.findAll());
		list.sort(Comparator
				.comparingInt(Doctor::getYearsOfExperience).reversed()
				.comparing(Doctor::getFullName));
		return list;
	}
}
