package co.edu.uptc.model;

public class MedicalAppoinmet {
    private int idMedicalAppointment;
    private String timeAppointment;
    private Patient patient;
    private Doctor doctor;
    
	public MedicalAppoinmet(int idMedicalAppointment, String timeAppointment, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppointment = idMedicalAppointment;
		this.timeAppointment = timeAppointment;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getIdMedicalAppointment() {
		return idMedicalAppointment;
	}

	public void setIdMedicalAppointment(int idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}

	public String getTimeAppointment() {
		return timeAppointment;
	}

	public void setTimeAppointment(String timeAppointment) {
		this.timeAppointment = timeAppointment;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "MedicalAppoinmet [idMedicalAppointment=" + idMedicalAppointment + ", timeAppointment=" + timeAppointment
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}
    
    
	
	
}