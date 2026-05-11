package co.edu.uptc.clinica.enums;

public enum IdentificationType {

    CC("Cedula de ciudadania"),
    TI("Tarjeta de identidad"),
    CE("Cedula de extranjeria"),
    PA("Pasaporte");

    private String officialName;

    IdentificationType(String officialName) {
        this.officialName = officialName;
    }

    public String getOfficialName() {
        return officialName;
    }
}