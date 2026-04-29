package co.edu.uptc.model;

import co.edu.uptc.enums.IdentificationType;
import co.edu.uptc.enums.Priority;

public class Patient {
    protected IdentificationType identificationType;
    protected int idPatient;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String medicationHistory;
    protected Priority priority;
    
    
    
    
	public Patient(IdentificationType identificationType, int idPatient, String firstName, String lastName,
			String email, String medicationHistory, Priority priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.medicationHistory = medicationHistory;
		this.priority = priority;
	}




	public IdentificationType getIdentificationType() {
		return identificationType;
	}




	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}




	public int getIdPatient() {
		return idPatient;
	}




	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getMedicationHistory() {
		return medicationHistory;
	}




	public void setMedicationHistory(String medicationHistory) {
		this.medicationHistory = medicationHistory;
	}




	public Priority getPriority() {
		return priority;
	}




	public void setPriority(Priority priority) {
		this.priority = priority;
	}




	@Override
	public String toString() {
		return "Patient [identificationType=" + identificationType + ", idPatient=" + idPatient + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", medicationHistory=" + medicationHistory
				+ ", priority=" + priority + "]";
	}
    
    
    
	
	
	
    
}
