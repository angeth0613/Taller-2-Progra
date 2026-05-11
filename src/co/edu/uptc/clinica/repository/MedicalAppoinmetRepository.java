package co.edu.uptc.clinica.repository;

import java.util.ArrayList;

import co.edu.uptc.clinica.domain.MedicalAppoinmet;

/**
 * Guarda citas médicas en memoria y permite buscarlas.
 */
public class MedicalAppoinmetRepository {

    private ArrayList<MedicalAppoinmet> appointments;

    public MedicalAppoinmetRepository() {
        appointments = new ArrayList<>();
    }

    /**
     * Añade una cita médica a la lista.
     *
     * @param appoinmet cita a guardar
     * @return true si la cita se agregó correctamente
     */
    public boolean addAppoinmet(MedicalAppoinmet appoinmet) {
        return appointments.add(appoinmet);
    }

    /**
     * Devuelve todas las citas registradas.
     *
     * @return lista de citas
     */
    public ArrayList<MedicalAppoinmet> findAll() {
        return appointments;
    }

    /**
     * Busca una cita por su identificación.
     *
     * @param id id de la cita
     * @return cita encontrada o null si no existe
     */
    public MedicalAppoinmet findById(int id) {

        for (MedicalAppoinmet appoinmet : appointments) {

            if (appoinmet.getIdMedicalAppoinmet() == id) {
                return appoinmet;
            }
        }

        return null;
    }
}