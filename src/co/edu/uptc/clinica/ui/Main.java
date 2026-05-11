package co.edu.uptc.clinica.ui;

import co.edu.uptc.clinica.domain.Doctor;
import co.edu.uptc.clinica.domain.MedicalAppoinmet;
import co.edu.uptc.clinica.domain.Patient;
import co.edu.uptc.clinica.enums.IdentificationType;
import co.edu.uptc.clinica.enums.Priority;
import co.edu.uptc.clinica.service.DoctorService;
import co.edu.uptc.clinica.service.MedicalAppoinmetService;
import co.edu.uptc.clinica.service.PatientService;

import javax.swing.JOptionPane;
import java.util.List;


public class Main {

	
	private PatientService patientService;

	
	private DoctorService doctorService;

	
	private MedicalAppoinmetService appoinmetService;

	
	public Main() {
		this.patientService = new PatientService();
		this.doctorService = new DoctorService();
		this.appoinmetService = new MedicalAppoinmetService(patientService, doctorService);
	}

	
	public void showMainMenu() {
		boolean running = true;
		while (running) {
			String[] options = {
					"Registrar Paciente",
					"Registrar Médico",
					"Registrar Cita Médica",
					"Agregar Medicamento a Paciente",
					"Ver Cola de Atención",
					"Ver Reporte de Médicos por Experiencia",
					"Ver Todos los Pacientes",
					"Ver Todos los Médicos",
					"Salir"
			};
			int choice = JOptionPane.showOptionDialog(
					null,
					"Clínica El Laguito\nSeleccione una opción:",
					"Menú Principal",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					options,
					options[0]);

			switch (choice) {
				case 0: registerPatient(); break;
				case 1: registerDoctor(); break;
				case 2: registerAppointment(); break;
				case 3: addMedicationToPatient(); break;
				case 4: showAttentionQueue(); break;
				case 5: showDoctorsByExperience(); break;
				case 6: showAllPatients(); break;
				case 7: showAllDoctors(); break;
				case 8:
				case -1:
					running = false;
					JOptionPane.showMessageDialog(null,
							"Gracias por usar el sistema de la Clínica El Laguito.",
							"Hasta luego", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					running = false;
					break;
			}
		}
	}

	
	private void registerPatient() {
		IdentificationType idType = selectIdentificationType();
		if (idType == null) return;

		String idInput = JOptionPane.showInputDialog(null,
				"Ingrese el número de identificación del paciente:",
				"Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		if (idInput == null || idInput.trim().isEmpty()) return;

		Long idPatient = Long.parseLong(idInput.trim());

		if (patientService.existsById(idPatient)) {
			JOptionPane.showMessageDialog(null,
					"Ya existe un paciente con la identificación: " + idPatient,
					"Paciente Duplicado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String firstName = JOptionPane.showInputDialog(null,
				"Ingrese el nombre del paciente:",
				"Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		if (firstName == null || firstName.trim().isEmpty()) return;

		String lastName = JOptionPane.showInputDialog(null,
				"Ingrese los apellidos del paciente:",
				"Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		if (lastName == null || lastName.trim().isEmpty()) return;

		String email = JOptionPane.showInputDialog(null,
				"Ingrese el correo electrónico del paciente:",
				"Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		if (email == null || email.trim().isEmpty()) return;

		if (patientService.existsByEmail(email.trim())) {
			JOptionPane.showMessageDialog(null,
					"Ya existe un paciente con el email: " + email.trim(),
					"Email Duplicado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Priority priority = selectPriority();
		if (priority == null) return;

		Patient patient = new Patient(idType, idPatient,
				firstName.trim(), lastName.trim(), email.trim(), priority);

		boolean result = patientService.addPatient(patient);

		if (result) {
			JOptionPane.showMessageDialog(null,
					"Paciente registrado exitosamente.\n" + patient,
					"Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"No fue posible registrar el paciente. Verifique los datos ingresados.",
					"Error en Registro", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	private void registerDoctor() {
		IdentificationType idType = selectIdentificationType();
		if (idType == null) return;

		String idInput = JOptionPane.showInputDialog(null,
				"Ingrese el número de identificación médica:",
				"Registrar Médico", JOptionPane.PLAIN_MESSAGE);
		if (idInput == null || idInput.trim().isEmpty()) return;

		Long medicalId = Long.parseLong(idInput.trim());

		if (doctorService.existsById(medicalId)) {
			JOptionPane.showMessageDialog(null,
					"Ya existe un médico con la identificación: " + medicalId,
					"Médico Duplicado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String firstName = JOptionPane.showInputDialog(null,
				"Ingrese el nombre del médico:",
				"Registrar Médico", JOptionPane.PLAIN_MESSAGE);
		if (firstName == null || firstName.trim().isEmpty()) return;

		String lastName = JOptionPane.showInputDialog(null,
				"Ingrese los apellidos del médico:",
				"Registrar Médico", JOptionPane.PLAIN_MESSAGE);
		if (lastName == null || lastName.trim().isEmpty()) return;

		String specialty = JOptionPane.showInputDialog(null,
				"Ingrese la especialidad del médico:",
				"Registrar Médico", JOptionPane.PLAIN_MESSAGE);
		if (specialty == null || specialty.trim().isEmpty()) return;

		String yearsInput = JOptionPane.showInputDialog(null,
				"Ingrese los años de experiencia del médico:",
				"Registrar Médico", JOptionPane.PLAIN_MESSAGE);
		if (yearsInput == null || yearsInput.trim().isEmpty()) return;

		Integer yearsOfExperience = Integer.parseInt(yearsInput.trim());

		Doctor doctor = new Doctor(idType, medicalId,
				firstName.trim(), lastName.trim(),
				specialty.trim(), yearsOfExperience);

		boolean result = doctorService.addDoctor(doctor);

		if (result) {
			JOptionPane.showMessageDialog(null,
					"Médico registrado exitosamente.\n" + doctor,
					"Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"No fue posible registrar el médico. Verifique los datos ingresados.",
					"Error en Registro", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	private void registerAppointment() {
		String idInput = JOptionPane.showInputDialog(null,
				"Ingrese el ID de la cita médica:",
				"Registrar Cita Médica", JOptionPane.PLAIN_MESSAGE);
		if (idInput == null || idInput.trim().isEmpty()) return;
		Long idAppointment = Long.parseLong(idInput.trim());

		String time = JOptionPane.showInputDialog(null,
				"Ingrese la hora de la cita (formato HH:mm):",
				"Registrar Cita Médica", JOptionPane.PLAIN_MESSAGE);
		if (time == null || time.trim().isEmpty()) return;

		String patientIdInput = JOptionPane.showInputDialog(null,
				"Ingrese el número de identificación del paciente:",
				"Registrar Cita Médica", JOptionPane.PLAIN_MESSAGE);
		if (patientIdInput == null || patientIdInput.trim().isEmpty()) return;
		Long idPatient = Long.parseLong(patientIdInput.trim());

		if (!patientService.existsById(idPatient)) {
			JOptionPane.showMessageDialog(null,
					"No se encontró ningún paciente con la identificación: " + idPatient,
					"Paciente No Encontrado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String doctorIdInput = JOptionPane.showInputDialog(null,
				"Ingrese el número de identificación del médico:",
				"Registrar Cita Médica", JOptionPane.PLAIN_MESSAGE);
		if (doctorIdInput == null || doctorIdInput.trim().isEmpty()) return;
		Long idDoctor = Long.parseLong(doctorIdInput.trim());

		if (!doctorService.existsById(idDoctor)) {
			JOptionPane.showMessageDialog(null,
					"No se encontró ningún médico con la identificación: " + idDoctor,
					"Médico No Encontrado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		boolean result = appointmentService.addAppointment(idAppointment, time.trim(), idPatient, idDoctor);

		if (result) {
			JOptionPane.showMessageDialog(null,
					"Cita médica registrada exitosamente.",
					"Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"Ya existe una cita médica con el ID: " + idAppointment,
					"Cita Duplicada", JOptionPane.WARNING_MESSAGE);
		}
	}

	
	private void addMedicationToPatient() {
		String idInput = JOptionPane.showInputDialog(null,
				"Ingrese el número de identificación del paciente:",
				"Agregar Medicamento", JOptionPane.PLAIN_MESSAGE);
		if (idInput == null || idInput.trim().isEmpty()) return;
		Long idPatient = Long.parseLong(idInput.trim());

		if (!patientService.existsById(idPatient)) {
			JOptionPane.showMessageDialog(null,
					"No se encontró ningún paciente con la identificación: " + idPatient,
					"Paciente No Encontrado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String medication = JOptionPane.showInputDialog(null,
				"Ingrese el nombre del medicamento a agregar:",
				"Agregar Medicamento", JOptionPane.PLAIN_MESSAGE);
		if (medication == null || medication.trim().isEmpty()) return;

		boolean result = patientService.addMedication(idPatient, medication.trim());

		if (result) {
			JOptionPane.showMessageDialog(null,
					"Medicamento '" + medication.trim() + "' agregado exitosamente al historial del paciente.",
					"Medicamento Agregado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"El medicamento '" + medication.trim() + "' ya se encuentra en el historial del paciente.",
					"Medicamento Duplicado", JOptionPane.WARNING_MESSAGE);
		}
	}

	
	private void showAttentionQueue() {
		List<MedicalAppoinmet> queue = appoinmetService.getAttentionQueue();
		if (queue.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"No hay citas médicas registradas en el sistema.",
					"Cola de Atención", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		StringBuilder sb = new StringBuilder("=== COLA DE ATENCIÓN ===\n\n");
		int position = 1;
		for (MedicalAppoinmet appoinmet : queue) {
			sb.append(position++).append(". ")
					.append("Hora: ").append(appoinmet.getTimeAppoinmet())
					.append(" | Paciente: ").append(appoinmet.getPatient().getFullName())
					.append(" | Prioridad: ").append(appoinmet.getPatient().getPriority().getDisplayName())
					.append(" | Médico: ").append(appoinmet.getDoctor().getFullName())
					.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString(),
				"Cola de Atención", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showDoctorsByExperience() {
		List<Doctor> doctors = doctorService.findAllOrderedByExperience();
		if (doctors.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"No hay médicos registrados en el sistema.",
					"Reporte por Experiencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		StringBuilder sb = new StringBuilder("=== REPORTE DE MÉDICOS POR EXPERIENCIA ===\n\n");
		int position = 1;
		for (Doctor doctor : doctors) {
			sb.append(position++).append(". ")
					.append(doctor.getFullName())
					.append(" | Especialidad: ").append(doctor.getSpecialty())
					.append(" | Experiencia: ").append(doctor.getYearsOfExperience()).append(" años")
					.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString(),
				"Reporte por Experiencia", JOptionPane.INFORMATION_MESSAGE);
	}

	
	private void showAllPatients() {
		if (patientService.findAll().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"No hay pacientes registrados en el sistema.",
					"Listado de Pacientes", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		StringBuilder sb = new StringBuilder("=== LISTADO DE PACIENTES ===\n\n");
		for (Patient patient : patientService.findAll()) {
			sb.append("- ").append(patient.getFullName())
					.append(" | ").append(patient.getIdentificationType().getOfficialName())
					.append(": ").append(patient.getIdPatient())
					.append(" | Email: ").append(patient.getEmail())
					.append(" | Prioridad: ").append(patient.getPriority().getDisplayName())
					.append(" | Medicamentos: ").append(patient.getMedicationHistory())
					.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString(),
				"Listado de Pacientes", JOptionPane.INFORMATION_MESSAGE);
	}

	
	private void showAllDoctors() {
		if (doctorService.findAll().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"No hay médicos registrados en el sistema.",
					"Listado de Médicos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		StringBuilder sb = new StringBuilder("=== LISTADO DE MÉDICOS ===\n\n");
		for (Doctor doctor : doctorService.findAll()) {
			sb.append("- ").append(doctor.getFullName())
					.append(" | ").append(doctor.getIdentificationType().getOfficialName())
					.append(": ").append(doctor.getMedicalId())
					.append(" | Especialidad: ").append(doctor.getSpecialty())
					.append(" | Experiencia: ").append(doctor.getYearsOfExperience()).append(" años")
					.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString(),
				"Listado de Médicos", JOptionPane.INFORMATION_MESSAGE);
	}

	
	private IdentificationType selectIdentificationType() {
		IdentificationType[] types = IdentificationType.values();
		String[] typeNames = new String[types.length];
		for (int i = 0; i < types.length; i++) {
			typeNames[i] = types[i].name() + " - " + types[i].getOfficialName();
		}
		int choice = JOptionPane.showOptionDialog(null,
				"Seleccione el tipo de identificación:",
				"Tipo de Identificación",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null, typeNames, typeNames[0]);
		if (choice == -1) return null;
		return types[choice];
	}

	
	private Priority selectPriority() {
		Priority[] priorities = Priority.values();
		String[] priorityNames = new String[priorities.length];
		for (int i = 0; i < priorities.length; i++) {
			priorityNames[i] = priorities[i].name() + " - " + priorities[i].getDisplayName();
		}
		int choice = JOptionPane.showOptionDialog(null,
				"Seleccione el nivel de prioridad del paciente:",
				"Prioridad",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null, priorityNames, priorityNames[0]);
		if (choice == -1) return null;
		return priorities[choice];
	}

	
	public static void main(String[] args) {
		Main app = new Main();
		app.showMainMenu();
	}
}
