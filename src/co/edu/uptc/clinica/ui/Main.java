package co.edu.uptc.clinica.ui;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.domain.MedicalAppoinmet;
import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
import co.edu.uptc.clinica.enums.PriorityEnum;
import co.edu.uptc.clinica.service.DoctorService;
import co.edu.uptc.clinica.service.MedicalAppoinmetService;
import co.edu.uptc.clinica.service.PatientService;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private PatientService patientService;
    private DoctorService doctorService;
    private MedicalAppoinmetService appoinmetService;

    public Main() {

        patientService = new PatientService();
        doctorService = new DoctorService();

        appoinmetService = new MedicalAppoinmetService(
                patientService,
                doctorService
        );
    }

    public void showMainMenu() {

        boolean running = true;

        while (running) {

            String option = JOptionPane.showInputDialog(
                    null,
                    " CLÍNICA EL LAGUITO \n\n"
                    + "1. Registrar Paciente\n"
                    + "2. Registrar Médico\n"
                    + "3. Registrar Cita\n"
                    + "4. Agregar Medicamento\n"
                    + "5. Ver fila de Atención\n"
                    + "6. Ver Médicos\n"
                    + "7. Ver Pacientes\n"
                    + "8. Salir\n\n"
                    + "seleccione lo que desea realizar:"
            );

            if (option == null) {
                return;
            }

            switch (option) {

                case "1":
                    registerPatient();
                    break;

                case "2":
                    registerDoctor();
                    break;

                case "3":
                    registerAppoinmet();
                    break;

                case "4":
                    addMedicationToPatient();
                    break;

                case "5":
                    showAttentionQueue();
                    break;

                case "6":
                    showAllDoctors();
                    break;

                case "7":
                    showAllPatients();
                    break;

                case "8":

                    JOptionPane.showMessageDialog(
                            null,
                            "Gracias por ingresar al sistema, tenga un muy buen dia"
                    );

                    running = false;
                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida, seleccione nuevamente"
                    );
            }
        }
    }

    private void registerPatient() {

        IdentificationTypeEnum idType =
                selectIdentificationType();

        if (idType == null) {
            return;
        }

        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del paciente"
                );

        int idPatient =
                Integer.parseInt(idInput);

        if (patientService.existsById(idPatient)) {

            JOptionPane.showMessageDialog(
                    null,
                    "El paciente ya existe"
            );

            return;
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

        if (patientService.existsByEmail(email)) {

            JOptionPane.showMessageDialog(
                    null,
                    "El email ya existe"
            );

            return;
        }

        PriorityEnum priority =
                selectPriority();

        Patient patient = new Patient(
                idType,
                idPatient,
                firstName,
                lastName,
                email,
                new ArrayList<>(),
                priority
        );

        boolean result =
                patientService.addPatient(patient);

        if (result) {

            JOptionPane.showMessageDialog(
                    null,
                    "Paciente registrado"
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al registrar paciente"
            );
        }
    }

    private void registerDoctor() {

        IdentificationTypeEnum idType =
                selectIdentificationType();

        if (idType == null) {
            return;
        }

        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del médico"
                );

        int medicalId =
                Integer.parseInt(idInput);

        if (doctorService.existsById(medicalId)) {

            JOptionPane.showMessageDialog(
                    null,
                    "El médico ya existe"
            );

            return;
        }

        String firstName =
                JOptionPane.showInputDialog(
                        "Ingrese nombre"
                );

        String lastName =
                JOptionPane.showInputDialog(
                        "Ingrese apellido"
                );

        String specialty =
                JOptionPane.showInputDialog(
                        "Ingrese especialidad"
                );

        String yearsInput =
                JOptionPane.showInputDialog(
                        "Ingrese años de experiencia"
                );

        int years =
                Integer.parseInt(yearsInput);

        Doctor doctor = new Doctor(
                idType,
                medicalId,
                firstName,
                lastName,
                specialty,
                years
        );

        boolean result =
                doctorService.addDoctor(doctor);

        if (result) {

            JOptionPane.showMessageDialog(
                    null,
                    "Médico registrado"
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al registrar médico"
            );
        }
    }

    private void registerAppoinmet() {

        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID de la cita"
                );
        
        int idAppoinmet =
                Integer.parseInt(idInput);

        String time =
                JOptionPane.showInputDialog(
                        "Ingrese hora"
                );

        String patientInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del paciente"
                );

        int idPatient =
                Integer.parseInt(patientInput);

        if (!patientService.existsById(idPatient)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Paciente no encontrado"
            );

            return;
        }

        String doctorInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del médico"
                );

        int idDoctor =
                Integer.parseInt(doctorInput);

        if (!doctorService.existsById(idDoctor)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Médico no encontrado"
            );

            return;
        }

        boolean result =
                appoinmetService.addAppoinmet(
                        idAppoinmet,
                        time,
                        idPatient,
                        idDoctor
                );

        if (result) {

            JOptionPane.showMessageDialog(
                    null,
                    "Cita registrada"
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al registrar cita"
            );
        }
    }

    private void addMedicationToPatient() {

        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del paciente"
                );

        int idPatient =
                Integer.parseInt(idInput);

        if (!patientService.existsById(idPatient)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Paciente no encontrado"
            );

            return;
        }

        String medication =
                JOptionPane.showInputDialog(
                        "Ingrese medicamento"
                );

        boolean result =
                patientService.addMedication(
                        idPatient,
                        medication
                );

        if (result) {

            JOptionPane.showMessageDialog(
                    null,
                    "Medicamento agregado"
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo agregar"
            );
        }
    }

    private void showAttentionQueue() {

        ArrayList<MedicalAppoinmet> list =
                appoinmetService.getAttentionQueue();

        String message = "";

        for (MedicalAppoinmet appoinmet : list) {

            message +=
                    "Hora: "
                    + appoinmet.getTimeAppoinmet()
                    + " | Paciente: "
                    + appoinmet.getPatient().getFirstName()
                    + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                message
        );
    }

    private void showAllDoctors() {

        String message = "";

        for (Doctor doctor : doctorService.findAll()) {

            message +=
                    doctor.getFirstName()
                    + " - "
                    + doctor.getSpecialty()
                    + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                message
        );
    }

    private void showAllPatients() {

        String message = "";

        for (Patient patient : patientService.findAll()) {

            message +=
                    patient.getFirstName()
                    + " - "
                    + patient.getPriorityEnum().name()
                    + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                message
        );
    }

    private IdentificationTypeEnum selectIdentificationType() {

        IdentificationTypeEnum[] types =
                IdentificationTypeEnum.values();

        String[] options =
                new String[types.length];

        for (int i = 0; i < types.length; i++) {

            options[i] = types[i].name();
        }

        int option =
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

        if (option == -1) {
            return null;
        }

        return types[option];
    }

    private PriorityEnum selectPriority() {

        PriorityEnum[] priorities =
                PriorityEnum.values();

        String[] options =
                new String[priorities.length];

        for (int i = 0; i < priorities.length; i++) {

            options[i] = priorities[i].name();
        }

        int option =
                JOptionPane.showOptionDialog(
                        null,
                        "Seleccione prioridad",
                        "Prioridad",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]
                );

        if (option == -1) {
            return null;
        }

        return priorities[option];
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.showMainMenu();
    }
    
}