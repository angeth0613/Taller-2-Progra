package co.edu.uptc.clinica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.domain.MedicalAppoinmet;
import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.repository.MedicalAppoinmetRepository;

public class MedicalAppoinmetService {

    private MedicalAppoinmetRepository appoinmetRepository;

    private PatientService patientService;

    private DoctorService doctorService;

    public MedicalAppoinmetService(PatientService patientService,
                                   DoctorService doctorService) {

        this.patientService = patientService;
        this.doctorService = doctorService;

        this.appoinmetRepository =
                new MedicalAppoinmetRepository();
    }

    public boolean addAppoinmet(int idAppoinmet,
                                String time,
                                int idPatient,
                                int idDoctor) {

        if (appoinmetRepository.findById(idAppoinmet) != null) {
            return false;
        }

        Patient patient =
                patientService.findById(idPatient);

        if (patient == null) {
            return false;
        }

        Doctor doctor =
                doctorService.findById(idDoctor);

        if (doctor == null) {
            return false;
        }

        MedicalAppoinmet appoinmet =
                new MedicalAppoinmet(
                        idAppoinmet,
                        time,
                        patient,
                        doctor
                );

        return appoinmetRepository
                .addAppoinmet(appoinmet);
    }

    public ArrayList<MedicalAppoinmet> findAll() {

        return appoinmetRepository.findAll();
    }

    public ArrayList<MedicalAppoinmet> getAttentionQueue() {

        ArrayList<MedicalAppoinmet> appointments =
                appoinmetRepository.findAll();

        Collections.sort(appointments,
                new Comparator<MedicalAppoinmet>() {

            @Override
            public int compare(MedicalAppoinmet a1,
                               MedicalAppoinmet a2) {

                return a1.getTimeAppoinmet()
                        .compareTo(a2.getTimeAppoinmet());
            }
        });

        return appointments;
    }
}