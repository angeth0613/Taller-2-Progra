package co.edu.uptc.clinica.repository;

import java.util.HashSet;
import java.util.Set;

import co.edu.uptc.clinica.domain.Doctor;

public class DoctorRepository {

    private Set<Doctor> doctors;

    public DoctorRepository() {
        doctors = new HashSet<>();
    }

    public boolean addDoctor(Doctor doctor) {
        return doctors.add(doctor);
    }

    public Set<Doctor> findAll() {
        return doctors;
    }

    public Doctor findById(int medicalId) {
        return doctors.stream()
                .filter(d -> d.getMedicalId() == medicalId)
                .findFirst()
                .orElse(null);
    }
}