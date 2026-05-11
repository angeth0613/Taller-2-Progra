package co.edu.uptc.clinica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.repository.PatientRepository;

public class PatientService {

    private PatientRepository patientRepository;

    public PatientService() {
        patientRepository = new PatientRepository();
    }

    public boolean addPatient(Patient patient) {

        if (patientRepository.findById(patient.getIdPatient()) != null) {
            return false;
        }

        if (patientRepository.findByEmail(patient.getEmail()) != null) {
            return false;
        }

        return patientRepository.addPatient(patient);
    }

    public ArrayList<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findById(int idPatient) {
        return patientRepository.findById(idPatient);
    }

    public boolean addMedication(int idPatient, String medication) {
        return patientRepository.addMedicationToPatient(idPatient, medication);
    }

    public ArrayList<Patient> findAllOrderedByPriority() {

        ArrayList<Patient> patients = patientRepository.findAll();

        Collections.sort(patients, new Comparator<Patient>() {

            @Override
            public int compare(Patient p1, Patient p2) {
                return p2.getPriority().getValue() - p1.getPriority().getValue();
            }
        });

        return patients;
    }
}