package menuPrincipal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Operaciones {
	private List<Paciente> pacientes = new ArrayList<Paciente>();

	public void registrar(Paciente p) {
		pacientes.add(p);
	}

	public int total() {
		return pacientes.size();
	}

	public List<Paciente> listarTodos() {
		return pacientes;
	}

	public List<Paciente> filtrarVacunados() {
		return pacientes.stream()
				.filter(Paciente::isVacunado)
				.collect(Collectors.toList());
	}

	public List<Paciente> filtrarPendientes() {
		return pacientes.stream()
				.filter(p -> !p.isVacunado())
				.collect(Collectors.toList());
	}

	public List<String> generarLineasReporte() {
		return pacientes.stream()
				.sorted(Comparator.comparing(Paciente::getApellidos))
				.map(Paciente::toString)
				.collect(Collectors.toList());
	}

	public double edadPromedio() {
		if (pacientes.isEmpty()) {
			throw new ArithmeticException("No hay personas registradas en esta jornada");
		}
		int sumaEdades = pacientes.stream()
				.map(Paciente::getEdad)
				.reduce(0, Integer::sum);
		return (double) sumaEdades / pacientes.size();
	}

	public Map<String, Long> contarPorVacuna() {
		return pacientes.stream()
				.filter(Paciente::isVacunado)
				.collect(Collectors.groupingBy(Paciente::getVacuna, TreeMap::new, Collectors.counting()));
	}

	public Paciente buscarPorDni(String dni) {
		return pacientes.stream()
				.filter(p -> p.getDni().equals(dni))
				.findFirst()
				.orElse(null);
	}

	public boolean existeRegistro(String dni) {
		return buscarPorDni(dni) != null;
	}
}
