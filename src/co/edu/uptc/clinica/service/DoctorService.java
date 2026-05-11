package co.edu.uptc.clinica.service;

import java.util.ArrayList;

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

    public ArrayList<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(int idDoctor) {
        return doctorRepository.findById(idDoctor);
    }

    public boolean existsById(int medicalId) {
        return doctorRepository.findById(medicalId) != null;
    }
}