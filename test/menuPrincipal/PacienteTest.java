package menuPrincipal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PacienteTest {
	@Test
	void elDniSeMuestraEnmascaradoYNuncaCompleto() {
		Paciente p = new Paciente("72014568", "Juan", "Perez", 34, "Fiebre amarilla", "Influenza");

		String dniMostrado = p.getDniEnmascarado();

		assertEquals("72***568", dniMostrado);
		assertFalse(dniMostrado.contains("014"));
	}

	@Test
	void losNombresSeGuardanEnMayusculas() {
		Paciente p = new Paciente("72014568", "juan", "perez", 34, "control", "Influenza");

		assertEquals("JUAN PEREZ", p.getNombreCompleto());
	}

	@Test
	void unPacienteNuevoEmpiezaComoNoVacunado() {
		Paciente p = new Paciente("72014568", "Juan", "Perez", 34, "control", "Influenza");

		assertFalse(p.isVacunado());
	}

	@Test
	void marcarComoVacunadoCambiaElEstado() {
		Paciente p = new Paciente("72014568", "Juan", "Perez", 34, "control", "Influenza");

		p.marcarComoVacunado();

		assertTrue(p.isVacunado());
	}

	@Test
	void laVacunaQuedaRegistradaYApareceEnElReporte() {
		Paciente p = new Paciente("72014568", "Juan", "Perez", 34, "control", "Fiebre amarilla");

		assertEquals("Fiebre amarilla", p.getVacuna());
		assertTrue(p.toString().contains("Fiebre amarilla"));
	}
}
