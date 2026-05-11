package co.edu.uptc.clinica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.repository.DoctorRepository;

public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService() {
        doctorRepository = new DoctorRepository();
    }

    public boolean addDoctor(Doctor doctor) {

        if (doctorRepository.findById(doctor.getMedicalId()) != null) {
            return false;
        }

        return doctorRepository.addDoctor(doctor);
    }

    public DoctorRepository findAll() {
        return doctorRepository;
    }

	

	public Doctor findById(int idDoctor) {
		// TODO Auto-generated method stub
		return null;
	}
}

