package co.edu.uptc.clinica.enums;

public enum PriorityEnum {
	    LOW(0),
	    MEDIUM(1),
	    HIGH(2),
	    CRITICAL(3);

	    private int value;

	    PriorityEnum(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }

	    
	    public String getDisplayName() {
	        return this.name();
	    }
	}


