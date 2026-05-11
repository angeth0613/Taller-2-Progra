package co.edu.uptc.clinica.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
import co.edu.uptc.clinica.repository.DoctorRepository;

public class DoctorService {

    private DoctorRepository doctorRepository;

    
    
    public DoctorService() {
        doctorRepository =
                new DoctorRepository();
    }

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

    public Doctor findById(int idDoctor) {
        return doctorRepository.findById(
                idDoctor);
    }
    
    
    

    public boolean existsById(int medicalId) {
        return doctorRepository.findById(
                medicalId
        ) != null;
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