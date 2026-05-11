package co.edu.uptc.clinica.domain;

import java.util.ArrayList;

import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
import co.edu.uptc.clinica.enums.PriorityEnum;

public class Patient {

    private IdentificationTypeEnum identificationTypeEnum;
    private int idPatient;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<String> medicationHistory;
    private PriorityEnum priorityEnum;

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





	public void setIdentificationTypeEnum(IdentificationTypeEnum identificationTypeEnum) {
		this.identificationTypeEnum = identificationTypeEnum;
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





	public void setPriority(PriorityEnum priorityEnum) {
		this.priorityEnum = priorityEnum;
	}





	public String getFullName() {
        return firstName + " " + lastName;
    }

    public IdentificationTypeEnum getIdentificationTypeEnum() {
        return identificationTypeEnum;
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
