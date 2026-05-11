package co.edu.uptc.clinica.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
import co.edu.uptc.clinica.enums.PriorityEnum;
import co.edu.uptc.clinica.repository.PatientRepository;

public class PatientService {

    private PatientRepository patientRepository;

    public PatientService() {

        patientRepository =
                new PatientRepository();
    }

    public String registerPatient() {

        IdentificationTypeEnum[] types =
                IdentificationTypeEnum.values();

        String[] options =
                new String[types.length];

        for (int i = 0; i < types.length; i++) {

            options[i] = types[i].name();
        }

        int typeOption =
                JOptionPane.showOptionDialog(
                        null,
                        "Seleccione identificación",
                        "Identificación",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]
                );

        if (typeOption == -1) {

            return "Operación cancelada";
        }

        IdentificationTypeEnum idType =
                types[typeOption];

        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del paciente"
                );

        if (!isNumeric(idInput)) {

            return "El ID debe ser numérico";
        }

        int idPatient =
                Integer.parseInt(idInput);

        if (existsById(idPatient)) {

            return "El paciente ya existe";
        }

        String firstName =
                JOptionPane.showInputDialog(
                        "Ingrese nombre"
                );

        String lastName =
                JOptionPane.showInputDialog(
                        "Ingrese apellido"
                );

        String email =
                JOptionPane.showInputDialog(
                        "Ingrese email"
                );

        if (existsByEmail(email)) {

            return "El email ya existe";
        }

        PriorityEnum[] priorities =
                PriorityEnum.values();

        String[] priorityOptions =
                new String[priorities.length];

        for (int i = 0; i < priorities.length; i++) {

            priorityOptions[i] =
                    priorities[i].name();
        }

        int priorityOption =
                JOptionPane.showOptionDialog(
                        null,
                        "Seleccione prioridad",
                        "Prioridad",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        priorityOptions,
                        priorityOptions[0]
                );

        if (priorityOption == -1) {

            return "Operación cancelada";
        }

        PriorityEnum priority =
                priorities[priorityOption];

        Patient patient =
                new Patient(
                        idType,
                        idPatient,
                        firstName,
                        lastName,
                        email,
                        new ArrayList<>(),
                        priority
                );

        boolean result =
                patientRepository.addPatient(
                        patient
                );

        if (result) {

            return "Paciente registrado";
        }

        return "Error al registrar paciente";
    }

    public String registerMedication() {

        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del paciente"
                );

        if (!isNumeric(idInput)) {

            return "El ID debe ser numérico";
        }

        int idPatient =
                Integer.parseInt(idInput);

        Patient patient =
                patientRepository.findById(
                        idPatient
                );

        if (patient == null) {

            return "Paciente no encontrado";
        }

        String medication =
                JOptionPane.showInputDialog(
                        "Ingrese medicamento"
                );

        patient.getMedicationHistory()
                .add(medication);

        return "Medicamento agregado";
    }

    public String showAllPatients() {

        ArrayList<Patient> patients =
                patientRepository.findAll();

        if (patients.isEmpty()) {

            return "No hay pacientes";
        }

        String message = "";

        for (Patient patient : patients) {

            message +=
                    patient.getFirstName()
                    + " - "
                    + patient.getPriorityEnum()
                    + "\n";
        }

        return message;
    }

    public boolean existsById(int idPatient) {

        return patientRepository.findById(
                idPatient
        ) != null;
    }

    public boolean existsByEmail(String email) {

        return patientRepository.findByEmail(
                email
        ) != null;
    }

    public Patient findById(int idPatient) {

        return patientRepository.findById(
                idPatient
        );
    }

    public boolean isNumeric(String text) {

        if (text == null || text.isEmpty()) {

            return false;
        }

        for (int i = 0; i < text.length(); i++) {

            if (!Character.isDigit(
                    text.charAt(i))) {

                return false;
            }
        }

        return true;
    }
}