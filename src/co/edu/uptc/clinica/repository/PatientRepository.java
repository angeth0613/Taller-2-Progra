package co.edu.uptc.clinica.repository;

import java.util.ArrayList;

import co.edu.uptc.clinica.domain.Patient;

/**
 * Guarda pacientes en memoria y permite buscarlos.
 */
public class PatientRepository {

    private ArrayList<Patient> patients;

    public PatientRepository() {
        patients = new ArrayList<>();
    }

    /**
     * Añade un paciente a la lista de pacientes.
     *
     * @param patient paciente a guardar
     * @return true si el paciente se agregó correctamente
     */
    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    /**
     * Devuelve todos los pacientes registrados.
     *
     * @return lista de pacientes
     */
    public ArrayList<Patient> findAll() {
        return patients;
    }

    /**
     * Busca un paciente por su identificación.
     *
     * @param idPatient id del paciente
     * @return paciente encontrado o null si no existe
     */
    public Patient findById(int idPatient) {

        for (Patient patient : patients) {

            if (patient.getIdPatient() == idPatient) {
                return patient;
            }
        }

        return null;
    }

    /**
     * Busca un paciente por su correo electrónico.
     *
     * @param email correo del paciente
     * @return paciente encontrado o null si no existe
     */
    public Patient findByEmail(String email) {

        for (Patient patient : patients) {

            if (patient.getEmail().equals(email)) {
                return patient;
            }
        }

        return null;
    }

    /**
     * Agrega un medicamento al historial del paciente.
     *
     * @param idPatient id del paciente
     * @param medication nombre del medicamento
     * @return true si el medicamento se agregó correctamente
     */
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