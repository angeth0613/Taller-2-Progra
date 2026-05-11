package co.edu.uptc.clinica.service;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.domain.MedicalAppoinmet;
import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.repository.MedicalAppoinmetRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class MedicalAppoinmetService {

	
	private MedicalAppoinmetRepository appoinmetRepository;

	
	private PatientService patientService;

	
	private DoctorService doctorService;

	
	public MedicalAppoinmetService(PatientService patientService, DoctorService doctorService) {
		this.appoinmetRepository = new MedicalAppoinmetRepository();
		this.patientService = patientService;
		this.doctorService = doctorService;
	}

	
	public boolean addAppoinmet(int idAppoinmet, String time, Long idPatient, Long idDoctor) {
		if (!Objects.isNull(appoinmetRepository.findById(idAppoinmet))) {
			return false;
		}
		Patient patient = patientService.findById(idPatient);
		if (Objects.isNull(patient)) {
			return false;
		}
		Doctor doctor = doctorService.findById(idDoctor);
		if (Objects.isNull(doctor)) {
			return false;
		}
		MedicalAppoinmet appoinmet = new MedicalAppoinmet(idAppoinmet, time, patient, doctor);
		return this.appoinmetRepository.addAppoinmet(appoinmet);
	}

	
	public Set<MedicalAppoinmet> findAll() {
		return this.appoinmetRepository.findAll();
	}

	public List<MedicalAppoinmet> getAttentionQueue() {
		List<MedicalAppoinmet> list = new ArrayList<>(this.appoinmetRepository.findAll());
		list.sort(Comparator
				.comparing(MedicalAppoinmet::getTimeAppoinmet)
				.thenComparingInt(a -> -a.getPatient().getPriority().getValue()));
		return list;
	}
}
