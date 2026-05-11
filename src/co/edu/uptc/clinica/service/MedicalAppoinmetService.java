package co.edu.uptc.clinica.service;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.domain.MedicalAppoinmet;
import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.repository.MedicalAppoinmetRepository;

/**
 * Controla el registro y la consulta de citas médicas.
 */
public class MedicalAppoinmetService {

    private MedicalAppoinmetRepository appoinmetRepository;

    private PatientService patientService;

    private DoctorService doctorService;
    

    public MedicalAppoinmetService(
            PatientService patientService,
            DoctorService doctorService) {
        this.patientService =
                patientService;
        this.doctorService =
                doctorService;
        appoinmetRepository =
                new MedicalAppoinmetRepository();
    }

    /**
     * Registra una cita médica con paciente y médico existentes.
     *
     * @return mensaje con el resultado del registro
     */
    public String registerAppoinmet() {
        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID de la cita");
        if (!isNumeric(idInput)) {
            JOptionPane.showMessageDialog(null, "el ID debe ser numerico");
            registerAppoinmet();  
        }

        int idAppoinmet =
                Integer.parseInt(idInput);
        if (appoinmetRepository.findById(idAppoinmet)
                != null) {
            return "La cita ya existe";
        }

        String time =
                JOptionPane.showInputDialog(
                        "Ingrese hora");
        String patientInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del paciente");
        if (!isNumeric(patientInput)) {
            return "El ID del paciente debe ser numérico";
        }

        int idPatient =
                Integer.parseInt(patientInput);
        Patient patient =
                patientService.findById(
                        idPatient);
        if (patient == null) {
            return "Paciente no encontrado";
        }

        String doctorInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del médico");
        if (!isNumeric(doctorInput)) {
            return "El ID del médico debe ser numérico";
        }

        int idDoctor =
                Integer.parseInt(doctorInput);
        Doctor doctor =
                doctorService.findById(
                        idDoctor);
        if (doctor == null) {
            return "Médico no encontrado";
        }

        MedicalAppoinmet appoinmet =
                new MedicalAppoinmet(
                        idAppoinmet,
                        time,
                        patient,
                        doctor);
        boolean result =
                appoinmetRepository.addAppoinmet(
                        appoinmet);

        if (result) {
            return "Cita registrada";
        }
        return "Error al registrar cita";
    }

    /**
     * Devuelve todas las citas médicas registradas.
     *
     * @return lista de citas
     */
    public ArrayList<MedicalAppoinmet> findAll() {
        return appoinmetRepository.findAll();
    }

    /**
     * Muestra la cola de atención con hora, paciente y médico.
     *
     * @return texto con la cola de atención o mensaje si no hay citas
     */
    public String showAttentionQueue() {
        ArrayList<MedicalAppoinmet> list =
                appoinmetRepository.findAll();
        if (list.isEmpty()) {
            return "No hay citas registradas";
        }

        String message = "";
        for (MedicalAppoinmet appoinmet : list) {
            message +=
                    "Hora: "
                    + appoinmet.getTimeAppoinmet()
                    + " | Paciente: "
                    + appoinmet.getPatient()
                    .getFirstName()
                    + " | Médico: "
                    + appoinmet.getDoctor()
                    .getFirstName()
                    + "\n";
        }
        return message;
    }

    /**
     * Verifica si un texto contiene solo dígitos.
     *
     * @param text texto a validar
     * @return true si es numérico
     */
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