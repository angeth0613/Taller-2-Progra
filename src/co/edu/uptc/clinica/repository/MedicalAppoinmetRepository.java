package co.edu.uptc.clinica.repository;
import co.edu.uptc.clinica.domain.MedicalAppoinmet;
import java.util.HashSet;
import java.util.Set;

public class MedicalAppoinmetRepository {

	
	private Set<MedicalAppoinmet> appoinmets;


	public MedicalAppoinmetRepository() {
		this.appoinmets = new HashSet<>();
	}

	public boolean addAppoinmet(MedicalAppoinmet appoinmet) {
		return this.appoinmets.add(appoinmet);
	}

	
	public Set<MedicalAppoinmet> findAll() {
		return this.appoinmets;
	}

	
	public MedicalAppoinmet findById(int idAppoinmet) {
		return this.appoinmets.stream()
				.filter(a -> a.getIdMedicalAppoinmet().equals(idAppoinmet))
				.findFirst().orElse(null);
	}
}
