package co.edu.uptc.clinica.repository;

import java.util.ArrayList;

import co.edu.uptc.clinica.domain.Doctor;

/**
 * Guarda médicos en memoria y permite buscarlos.
 */
public class DoctorRepository {
	

    private ArrayList<Doctor> doctors;
    public DoctorRepository() {
        doctors = new ArrayList<>();
    }

    
    /**
     * Añade un médico a la lista de médicos.
     *
     * @param doctor médico a guardar
     * @return true si el médico se agregó correctamente
     */
    public boolean addDoctor(Doctor doctor) {
        return doctors.add(doctor);
    }

    /**
     * Devuelve todos los médicos registrados.
     *
     * @return lista de médicos
     */
    public ArrayList<Doctor> findAll() {
        return doctors;
    }

    /**
     * Busca un médico por su identificación.
     *
     * @param medicalId id del médico
     * @return médico encontrado o null si no existe
     */
    public Doctor findById(int medicalId) {
        for (Doctor doctor : doctors) {

            if (doctor.getMedicalId() == medicalId) {
                return doctor;
            }
        }return null;
 
    }
}