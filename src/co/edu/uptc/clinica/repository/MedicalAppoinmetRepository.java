package co.edu.uptc.clinica.repository;

import java.util.HashSet;
import java.util.Set;

import co.edu.uptc.clinica.domain.MedicalAppoinmet;

public class MedicalAppoinmetRepository {

    private Set<MedicalAppoinmet> appointments;

    public MedicalAppoinmetRepository() {
        appointments = new HashSet<>();
    }

    public boolean addAppoinmet(MedicalAppoinmet appoinmet) {
        return appointments.add(appoinmet);
    }

    public Set<MedicalAppoinmet> findAll() {
        return appointments;
    }

    public MedicalAppoinmet findById(int id) {

        return appointments.stream()
                .filter(a -> a.getIdMedicalAppoinmet() == id)
                .findFirst()
                .orElse(null);
    }
}