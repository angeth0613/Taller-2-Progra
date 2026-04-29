package co.edu.uptc.model;

import co.edu.uptc.enums.IdentificationType;

public class Doctor {
    private IdentificationType identificationType;
    private int medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;
    
    
	public Doctor(IdentificationType identificationType, int medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}


	public IdentificationType getIdentificationType() {
		return identificationType;
	}


	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}


	public int getMedicalId() {
		return medicalId;
	}


	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
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


	public String getSpecialty() {
		return specialty;
	}


	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}


	public int getYearsOfExperience() {
		return yearsOfExperience;
	}


	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}


	@Override
	public String toString() {
		return "Doctor [identificationType=" + identificationType + ", medicalId=" + medicalId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", specialty=" + specialty + ", yearsOfExperience="
				+ yearsOfExperience + "]";
	}
    
    
    
}