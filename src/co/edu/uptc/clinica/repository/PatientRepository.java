package co.edu.uptc.clinica.repository;

import java.util.ArrayList;

import co.edu.uptc.clinica.domain.Patient;

public class PatientRepository {

    private ArrayList<Patient> patients;

    public PatientRepository() {
        patients = new ArrayList<>();
    }

    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    public ArrayList<Patient> findAll() {
        return patients;
    }

    public Patient findById(int idPatient) {

        for (Patient patient : patients) {

            if (patient.getIdPatient() == idPatient) {
                return patient;
            }
        }

        return null;
    }

    public Patient findByEmail(String email) {

        for (Patient patient : patients) {

            if (patient.getEmail().equals(email)) {
                return patient;
            }
        }

        return null;
    }

    public boolean addMedicationToPatient(int idPatient,
                                          String medication) {

        Patient patient = findById(idPatient);

        if (patient == null) {
            return false;
        }

        patient.getMedicationHistory().add(medication);

        return true;
    }
}