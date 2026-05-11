package co.edu.uptc.clinica.domain;

import java.util.ArrayList;

import co.edu.uptc.clinica.enums.IdentificationType;
import co.edu.uptc.clinica.enums.Priority;

public class Patient {

    private IdentificationType identificationType;
    private int idPatient;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<String> medicationHistory;
    private Priority priority;

    public Patient(IdentificationType identificationType,
                   int idPatient,
                   String firstName,
                   String lastName,
                   String email,
                   ArrayList<String> medicationHistory,
                   Priority priority) {

        this.identificationType = identificationType;
        this.idPatient = idPatient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.medicationHistory = medicationHistory;
        this.priority = priority;
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





	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}





	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public void setMedicationHistory(ArrayList<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}





	public void setPriority(Priority priority) {
		this.priority = priority;
	}





	public String getFullName() {
        return firstName + " " + lastName;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getMedicationHistory() {
        return medicationHistory;
    }

    public Priority getPriority() {
        return priority;
    }
}