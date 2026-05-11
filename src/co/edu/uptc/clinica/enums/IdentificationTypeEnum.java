package co.edu.uptc.clinica.enums;

/**
 * Tipos de identificación usados en el sistema.
 */
public enum IdentificationTypeEnum {

	    CC("Cedula de ciudadania"),
	    TI("Tarjeta de identidad"),
	    CE("Cedula de extranjeria"),
	    PA("Pasaporte");

	    private String officialName;

	    IdentificationTypeEnum(String officialName) {
	        this.officialName = officialName;
	    }

	    
	    
	    /**
	     * Devuelve el nombre oficial del tipo de identificación.
	     *
	     * @return nombre oficial del tipo de identificación
	     */
	    public String getOfficialName() {
	        return officialName;
	    }
	}

