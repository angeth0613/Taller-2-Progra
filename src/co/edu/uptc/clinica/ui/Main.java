package co.edu.uptc.clinica.ui;

import co.edu.uptc.clinica.service.DoctorService;
import co.edu.uptc.clinica.service.MedicalAppoinmetService;
import co.edu.uptc.clinica.service.PatientService;

import javax.swing.JOptionPane;

public class Main {

    private PatientService patientService;
    private DoctorService doctorService;
    private MedicalAppoinmetService appoinmetService;

    public Main() {

        patientService = new PatientService();

        doctorService = new DoctorService();

        appoinmetService =
                new MedicalAppoinmetService(
                        patientService,
                        doctorService);
    }

    public void showMainMenu() {
        boolean running = true;
        while (running) {
            String option =
                    JOptionPane.showInputDialog(
                            null,

                            "CLÍNICA EL LAGUITO\n\n"
                            + "1. Registrar Paciente\n"
                            + "2. Registrar Médico\n"
                            + "3. Registrar Cita\n"
                            + "4. Agregar Medicamento\n"
                            + "5. Ver Cola de Atención\n"
                            + "6. Ver Médicos\n"
                            + "7. Ver Pacientes\n"
                            + "8. Salir\n\n"
                            + "Seleccione una opción:");

            if (option == null) {
                return;
            }
            switch (option) {
                case "1":
                    JOptionPane.showMessageDialog(
                            null,
                            patientService.registerPatient());
                    break;
                case "2":
                    JOptionPane.showMessageDialog(
                            null,
                            doctorService.registerDoctor());
                    break;

                case "3":
                    JOptionPane.showMessageDialog(
                            null,
                            appoinmetService.registerAppoinmet());
                    break;

                case "4":
                    JOptionPane.showMessageDialog(
                            null,
                            patientService.registerMedication());
                    break;

                case "5":
                    JOptionPane.showMessageDialog(
                            null,
                            appoinmetService.showAttentionQueue());

                    break;

                case "6":
                    JOptionPane.showMessageDialog(
                            null,

                            doctorService.showAllDoctors());

                    break;

                case "7":

                    JOptionPane.showMessageDialog(
                            null,

                            patientService.showAllPatients());
                    break;

                case "8":

                    
                	JOptionPane.showMessageDialog(
                            null,

                            "Gracias por ingresar al sistema, que tengas un buen dia");

                    running = false;

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,

                            "Opción inválida");
            }
        }
    }

    public static void main(String[] args) {

        Main main = new Main();

        main.showMainMenu();
    }
}