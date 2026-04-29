package co.edu.uptc.clinica.enums;


public enum Priority {
	LOW(0),
    MEDIUM(1),
    HIGH(2),
    CRITICAL(3);
	private int value;
	
	

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
	

}
