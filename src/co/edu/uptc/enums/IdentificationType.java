package co.edu.uptc.enums;

public enum IdentificationType {
    CC("Cédula de ciudadanía"),
    TI("Tarjeta de identidad"),
    CE("Cédula de extranjería"),
    PA("Pasaporte");

    private String nombre;
    
    
    

    IdentificationType(String nombre) {
        this.nombre = nombre;
    }
}