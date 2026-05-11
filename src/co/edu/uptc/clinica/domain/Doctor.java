package co.edu.uptc.clinica.domain;

import co.edu.uptc.clinica.enums.IdentificationTypeEnum;
/** 
 * <b>Descripción: </b> Representa un médico en la clínica.
 * Contiene datos de identificación, especialidad y experiencia. <br>
 * 
 * @author Angélica Beltrán
 * {@code 202520199}
*/


public class Doctor {
    private IdentificationTypeEnum identificationTypeEnum;
    private int medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;
    
    
    
    
	/**
	 * Crea un nuevo médico con los datos básicos.
	 *
	 * @param identificationTypeEnum tipo de identificación del médico
	 * @param medicalId número de identificación del médico
	 * @param firstName nombre del médico
	 * @param lastName apellido del médico
	 * @param specialty especialidad del médico
	 * @param yearsOfExperience años de experiencia del médico
	 */
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


	/**
	 * Devuelve el tipo de identificación del médico.
	 *
	 * @return tipo de identificación
	 */
	public IdentificationTypeEnum getIdentificationTypeEnum() {
		return identificationTypeEnum;
	}


	/**
	 * Cambia el tipo de identificación del médico.
	 *
	 * @param identificationTypeEnum nuevo tipo de identificación
	 */
	public void setIdentificationType(IdentificationTypeEnum identificationTypeEnum) {
		this.identificationTypeEnum = identificationTypeEnum;
	}



    /**
     * Devuelve el número de identificación del médico.
     *
     * @return id del médico
     */
    public int getMedicalId() {
        return medicalId;
    }


    /**
     * Cambia el número de identificación del médico.
     *
     * @param medicalId nuevo id del médico
     */
    public void setMedicalId(int medicalId) {
        this.medicalId = medicalId;
    }


    /**
     * Devuelve el nombre del médico.
     *
     * @return nombre del médico
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Cambia el nombre del médico.
     *
     * @param firstName nuevo nombre del médico
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


/**
     * Devuelve el apellido del médico.
     *
     * @return apellido del médico
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Cambia el apellido del médico.
     *
     * @param lastName nuevo apellido del médico
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Devuelve la especialidad del médico.
     *
     * @return especialidad médica
     */
	public String getSpecialty() {
		return specialty;
	}


/**
     * Cambia la especialidad del médico.
     *
     * @param specialty nueva especialidad médica
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    /**
     * Devuelve los años de experiencia del médico.
     *
     * @return años de experiencia
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }


    /**
     * Cambia los años de experiencia del médico.
     *
     * @param yearsOfExperience nuevos años de experiencia
     */
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



