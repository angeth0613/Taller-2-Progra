package co.edu.uptc.clinica.repository;

import java.util.ArrayList;

import co.edu.uptc.clinica.domain.MedicalAppoinmet;

public class MedicalAppoinmetRepository {

    private ArrayList<MedicalAppoinmet> appointments;

    public MedicalAppoinmetRepository() {
        appointments = new ArrayList<>();
    }

    public boolean addAppoinmet(MedicalAppoinmet appoinmet) {
        return appointments.add(appoinmet);
    }

    public ArrayList<MedicalAppoinmet> findAll() {
        return appointments;
    }

    public MedicalAppoinmet findById(int id) {

        for (MedicalAppoinmet appoinmet : appointments) {

            if (appoinmet.getIdMedicalAppoinmet() == id) {
                return appoinmet;
            }
        }

        return null;
    }
}