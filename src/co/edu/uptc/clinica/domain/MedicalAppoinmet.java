package co.edu.uptc.clinica.domain;

/** 
 * <b>Descripción: </b> Representa una cita médica.
 *  Contiene hora, paciente y médico asignado. <br>
 * 
 * @author Angélica Beltrán
 * {@code 202520199}*/

public class MedicalAppoinmet {
    private int idMedicalAppoinmet;
    private String timeAppoinmet;
    private Patient patient;
    private Doctor doctor;
    
	/**
	 * Crea una cita médica con paciente y doctor.
	 *
	 * @param idMedicalAppoinmet id de la cita
	 * @param timeAppoinmet hora de la cita
	 * @param patient paciente de la cita
	 * @param doctor médico asignado a la cita
	 */
	public MedicalAppoinmet(int idMedicalAppoinmet, String timeAppoinmet, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppoinmet = idMedicalAppoinmet;
		this.timeAppoinmet = timeAppoinmet;
		this.patient = patient;
		this.doctor = doctor;
	}

	
	/**
	 * Devuelve el id de la cita médica.
	 *
	 * @return id de la cita
	 */
	public int getIdMedicalAppoinmet() {
		return idMedicalAppoinmet;
	}


	/**
	 * Cambia el id de la cita médica.
	 *
	 * @param idMedicalAppoinmet nuevo id de la cita
	 */
	public void setIdMedicalAppoinmet(int idMedicalAppoinmet) {
		this.idMedicalAppoinmet = idMedicalAppoinmet;
	}


	/**
	 * Devuelve la hora de la cita médica.
	 *
	 * @return hora de la cita
	 */
	public String getTimeAppoinmet() {
		return timeAppoinmet;
	}


	/**
	 * Cambia la hora de la cita médica.
	 *
	 * @param timeAppoinmet nueva hora de la cita
	 */
	public void setTimeAppoinmet(String timeAppoinmet) {
		this.timeAppoinmet = timeAppoinmet;
	}


	/**
	 * Devuelve el paciente de la cita.
	 *
	 * @return paciente de la cita
	 */
	public Patient getPatient() {
		return patient;
	}


	/**
	 * Cambia el paciente de la cita.
	 *
	 * @param patient nuevo paciente de la cita
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	/**
	 * Devuelve el médico asignado a la cita.
	 *
	 * @return médico de la cita
	 */
	public Doctor getDoctor() {
		return doctor;
	}


	/**
	 * Cambia el médico asignado a la cita.
	 *
	 * @param doctor nuevo médico de la cita
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	@Override
	public String toString() {
		return "MedicalAppoinmet [idMedicalAppoinmet=" + idMedicalAppoinmet + ", timeAppointment=" + timeAppoinmet
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}
    
    
	
	
}

