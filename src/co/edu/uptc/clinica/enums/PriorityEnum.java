package co.edu.uptc.clinica.enums;

/**
 * Niveles de prioridad para los pacientes.
 */
public enum PriorityEnum {
	    LOW(0),
	    MEDIUM(1),
	    HIGH(2),
	    CRITICAL(3);

	    private int value;

	    PriorityEnum(int value) {
	        this.value = value;
	    }

/**
	     * Devuelve el valor entero de la prioridad.
	     *
	     * @return valor numérico de la prioridad
	     */
	    public int getValue() {
	        return value;
	    }

	    	
	    /**
	     * Devuelve el nombre de la prioridad como texto.
	     *
	     * @return nombre de la prioridad
	     */
	    public String getDisplayName() {
	        return this.name();
	    }
	}


