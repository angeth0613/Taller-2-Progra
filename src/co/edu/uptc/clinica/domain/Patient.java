package co.edu.uptc.clinica.domain;

import java.util.ArrayList;

import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
import co.edu.uptc.clinica.enums.PriorityEnum;

/**
 * Representa un paciente de la clínica.
 * Guarda información personal, correo, medicamentos y prioridad.
 */
public class Patient {

    private IdentificationTypeEnum identificationTypeEnum;
    private int idPatient;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<String> medicationHistory;
    private PriorityEnum priorityEnum;

    /**
     * Crea un paciente con sus datos iniciales.
     *
     * @param identificationTypeEnum tipo de identificación
     * @param idPatient identificador del paciente
     * @param firstName nombre del paciente
     * @param lastName apellido del paciente
     * @param email correo electrónico del paciente
     * @param medicationHistory lista de medicamentos
     * @param priorityEnum nivel de prioridad del paciente
     */
    public Patient(IdentificationTypeEnum identificationTypeEnum,
                   int idPatient,
                   String firstName,
                   String lastName,
                   String email,
                   ArrayList<String> medicationHistory,
                   PriorityEnum priorityEnum) {

        this.identificationTypeEnum = identificationTypeEnum;
        this.idPatient = idPatient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.medicationHistory = medicationHistory;
        this.priorityEnum = priorityEnum;
    }
    
    
    
    

/**
     * Devuelve el nombre del paciente.
     *
     * @return nombre del paciente
     */
    public String getFirstName() {
		return firstName;
	}





    /**
     * Cambia el nombre del paciente.
     *
     * @param firstName nuevo nombre del paciente
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





/**
     * Devuelve el apellido del paciente.
     *
     * @return apellido del paciente
     */
    public String getLastName() {
		return lastName;
	}





    /**
     * Cambia el apellido del paciente.
     *
     * @param lastName nuevo apellido del paciente
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





/**
     * Cambia el tipo de identificación del paciente.
     *
     * @param identificationTypeEnum nuevo tipo de identificación
     */
    public void setIdentificationTypeEnum(IdentificationTypeEnum identificationTypeEnum) {
		this.identificationTypeEnum = identificationTypeEnum;
	}





    /**
     * Cambia la identificación del paciente.
     *
     * @param idPatient nuevo id del paciente
     */
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}





/**
     * Cambia el correo del paciente.
     *
     * @param email nuevo correo del paciente
     */
    public void setEmail(String email) {
		this.email = email;
	}





    /**
     * Cambia el historial de medicamentos del paciente.
     *
     * @param medicationHistory nueva lista de medicamentos
     */
	public void setMedicationHistory(ArrayList<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}





/**
     * Cambia la prioridad del paciente.
     *
     * @param priorityEnum nuevo nivel de prioridad
     */
    public void setPriority(PriorityEnum priorityEnum) {
		this.priorityEnum = priorityEnum;
	}





    /**
     * Devuelve el nombre completo del paciente.
     *
     * @return nombre y apellido unidos
     */
	public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Devuelve el tipo de identificación del paciente.
     *
     * @return tipo de identificación
     */
    public IdentificationTypeEnum getIdentificationTypeEnum() {
        return identificationTypeEnum;
    }

    /**
     * Devuelve el id del paciente.
     *
     * @return id del paciente
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * Devuelve el correo del paciente.
     *
     * @return correo del paciente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Devuelve la lista de medicamentos del paciente.
     *
     * @return historial de medicamentos
     */
    public ArrayList<String> getMedicationHistory() {
        return medicationHistory;
    }

    /**
     * Devuelve la prioridad del paciente.
     *
     * @return prioridad del paciente
     */
    public PriorityEnum getPriorityEnum() {
        return priorityEnum;
    }





	@Override
	public String toString() {
		return "Patient [identificationTypeEnum=" + identificationTypeEnum + ", idPatient=" + idPatient + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", medicationHistory=" + medicationHistory
				+ ", priorityEnum=" + priorityEnum + "]";
	}
}
