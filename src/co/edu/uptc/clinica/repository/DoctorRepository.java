package co.edu.uptc.clinica.repository;

import java.util.ArrayList;

import co.edu.uptc.clinica.domain.Doctor;

public class DoctorRepository {
	

    private ArrayList<Doctor> doctors;
    public DoctorRepository() {
        doctors = new ArrayList<>();
    }

    
    public boolean addDoctor(Doctor doctor) {
        return doctors.add(doctor);
    }

    
    
    public ArrayList<Doctor> findAll() {
        return doctors;
    }

    public Doctor findById(int medicalId) {
        for (Doctor doctor : doctors) {

            if (doctor.getMedicalId() == medicalId) {
                return doctor;
            }
        }return null;
 
    }
}