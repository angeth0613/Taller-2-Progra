package co.edu.uptc.clinica.domain;

import co.edu.uptc.clinica.enums.IdentificationTypeEnum;

public class Doctor {
    private IdentificationTypeEnum identificationTypeEnum;
    private int medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;
    
    
    
    
	public Doctor(IdentificationTypeEnum identificationTypeEnum, int medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationTypeEnum = identificationTypeEnum;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}


	public IdentificationTypeEnum getIdentificationTypeEnum() {
		return identificationTypeEnum;
	}


	public void setIdentificationType(IdentificationTypeEnum identificationTypeEnum) {
		this.identificationTypeEnum = identificationTypeEnum;
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
		return "Doctor [identificationTypeEnum=" + identificationTypeEnum + ", medicalId=" + medicalId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", specialty=" + specialty + ", yearsOfExperience="
				+ yearsOfExperience + "]";
	}
    
    
    
}



