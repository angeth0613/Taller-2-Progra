package co.edu.uptc.clinica.repository;

import java.util.HashSet;
import java.util.Set;

import co.edu.uptc.clinica.domain.Patient;

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

    public Patient findById(int idPatient) {

        return this.patients.stream()
                .filter(p -> p.getIdPatient() == idPatient)
                .findFirst()
                .orElse(null);
    }

    public Patient findByEmail(String email) {

        return this.patients.stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public boolean addMedicationToPatient(int idPatient, String medication) {

        Patient patient = findById(idPatient);

        if (patient != null) {

            return patient.getMedicationHistory().add(medication);
        }

        return false;
    }
}