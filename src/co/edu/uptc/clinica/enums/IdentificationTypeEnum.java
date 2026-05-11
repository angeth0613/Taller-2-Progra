package co.edu.uptc.clinica.enums;

public enum IdentificationTypeEnum {

	    CC("Cedula de ciudadania"),
	    TI("Tarjeta de identidad"),
	    CE("Cedula de extranjeria"),
	    PA("Pasaporte");

	    private String officialName;

	    IdentificationTypeEnum(String officialName) {
	        this.officialName = officialName;
	    }

	    
	    
	    public String getOfficialName() {
	        return officialName;
	    }
	}

