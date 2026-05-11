package co.edu.uptc.clinica.domain;


public class MedicalAppoinmet {
    private int idMedicalAppoinmet;
    private String timeAppoinmet;
    private Patient patient;
    private Doctor doctor;
    
	public MedicalAppoinmet(int idMedicalAppoinmet, String timeAppoinmet, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppoinmet = idMedicalAppoinmet;
		this.timeAppoinmet = timeAppoinmet;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getIdMedicalAppoinmet() {
		return idMedicalAppoinmet;
	}

	public void setIdMedicalAppoinmet(int idMedicalAppoinmet) {
		this.idMedicalAppoinmet = idMedicalAppoinmet;
	}

	public String getTimeAppoinmet() {
		return timeAppoinmet;
	}

	public void setTimeAppoinmet(String timeAppoinmet) {
		this.timeAppoinmet = timeAppoinmet;
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
		return "MedicalAppoinmet [idMedicalAppoinmet=" + idMedicalAppoinmet + ", timeAppointment=" + timeAppoinmet
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}
    
    
	
	
}

