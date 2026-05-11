package co.edu.uptc.clinica.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
import co.edu.uptc.clinica.repository.DoctorRepository;

/**
 * Controla el registro y la consulta de médicos.
 */
public class DoctorService {

    private DoctorRepository doctorRepository;

    
    
    public DoctorService() {
        doctorRepository =
                new DoctorRepository();
    }

    /**
     * Registra un médico usando ventanas de diálogo.
     *
     * @return mensaje con el resultado del registro
     */
    public String registerDoctor() {
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
                        options[0]);
        if (typeOption == -1) {
            return "Operación cancelada";
        }
        IdentificationTypeEnum idType =
                types[typeOption];
        String idInput =
                JOptionPane.showInputDialog(
                        "Ingrese ID del médico");
        if (!isNumeric(idInput)) {
            return "El ID debe ser numérico";
        }
        
        
        int medicalId =
                Integer.parseInt(idInput);
        if (existsById(medicalId)) {
            return "El médico ya existe";
        }
        String firstName =
                JOptionPane.showInputDialog(
                        "Ingrese nombre");
        
        
        String lastName =
                JOptionPane.showInputDialog(
                        "Ingrese apellido");
        
        String specialty =
                JOptionPane.showInputDialog(
                        "Ingrese especialidad");
        String yearsInput =
                JOptionPane.showInputDialog(
                        "Ingrese experiencia");
        
        if (!isNumeric(yearsInput)) {
            return "La experiencia debe ser numérica";
        }
        
        
        int years =
                Integer.parseInt(yearsInput);
        Doctor doctor =
                new Doctor(
                        idType,
                        medicalId,
                        firstName,
                        lastName,
                        specialty,
                        years);
        boolean result =
                doctorRepository.addDoctor(
                        doctor);
        if (result) {
            return "Médico registrado";
        }
        return "Error al registrar médico";
    }

    /**
     * Muestra todos los médicos registrados en un texto simple.
     *
     * @return lista de médicos o mensaje si no hay ninguno
     */
    public String showAllDoctors() {
        ArrayList<Doctor> doctors =
                doctorRepository.findAll();
        if (doctors.isEmpty()) {
            return "No hay médicos";
        }
        String message = "";
        for (Doctor doctor : doctors) {
            message +=
                    doctor.getFirstName()
                    + " - "
                    + doctor.getSpecialty()
                    + "\n";
        }
        return message;
    }

    /**
     * Busca un médico por su id.
     *
     * @param idDoctor identificación del médico
     * @return médico encontrado o null si no existe
     */
    public Doctor findById(int idDoctor) {
        return doctorRepository.findById(
                idDoctor);
    }
    
    
    

    /**
     * Verifica si existe un médico con ese id.
     *
     * @param medicalId identificación del médico
     * @return true si el médico ya está registrado
     */
    public boolean existsById(int medicalId) {
        return doctorRepository.findById(
                medicalId
        ) != null;
    }
    

    /**
     * Verifica si un texto contiene solo dígitos.
     *
     * @param text texto a validar
     * @return true si es un número entero válido
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