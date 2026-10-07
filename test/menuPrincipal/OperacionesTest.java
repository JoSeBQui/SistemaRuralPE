package menuPrincipal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OperacionesTest {
	@Test
	void edadPromedioLanzaExcepcionSiNoHayPacientes() {
		Operaciones operaciones = new Operaciones();

		assertThrows(ArithmeticException.class, () -> operaciones.edadPromedio());
	}

	@Test
	void edadPromedioCalculaCorrectamenteConVariosPacientes() {
		Operaciones operaciones = new Operaciones();
		operaciones.registrar(new Paciente("72014568", "Juan", "Perez", 30, "control", "Influenza"));
		operaciones.registrar(new Paciente("45871023", "Maria", "Diaz", 40, "control", "Influenza"));

		double promedio = operaciones.edadPromedio();

		assertEquals(35.0, promedio);
	}

	@Test
	void existeRegistroDetectaUnaPersonaYaRegistrada() {
		Operaciones operaciones = new Operaciones();
		operaciones.registrar(new Paciente("72014568", "Juan", "Perez", 30, "control", "Influenza"));

		assertEquals(true, operaciones.existeRegistro("72014568"));
		assertEquals(false, operaciones.existeRegistro("00000000"));
	}

	@Test
	void filtrarVacunadosSoloDevuelveLosMarcadosComoVacunados() {
		Operaciones operaciones = new Operaciones();
		Paciente p1 = new Paciente("72014568", "Juan", "Perez", 30, "control", "Influenza");
		Paciente p2 = new Paciente("45871023", "Maria", "Diaz", 40, "control", "Influenza");
		p1.marcarComoVacunado();
		operaciones.registrar(p1);
		operaciones.registrar(p2);

		assertEquals(1, operaciones.filtrarVacunados().size());
		assertEquals(1, operaciones.filtrarPendientes().size());
	}

	@Test
	void contarPorVacunaAgrupaSoloLasDosisAplicadas() {
		Operaciones operaciones = new Operaciones();
		Paciente p1 = new Paciente("72014568", "Juan", "Perez", 30, "control", "Influenza");
		Paciente p2 = new Paciente("45871023", "Maria", "Diaz", 40, "control", "Influenza");
		Paciente p3 = new Paciente("10203040", "Rosa", "Lopez", 25, "embarazo", "Hepatitis B");
		Paciente p4 = new Paciente("50607080", "Luis", "Rojas", 50, "control", "COVID-19");
		p1.marcarComoVacunado();
		p2.marcarComoVacunado();
		p3.marcarComoVacunado();
		operaciones.registrar(p1);
		operaciones.registrar(p2);
		operaciones.registrar(p3);
		operaciones.registrar(p4);

		assertEquals(2L, operaciones.contarPorVacuna().get("Influenza"));
		assertEquals(1L, operaciones.contarPorVacuna().get("Hepatitis B"));
		assertEquals(false, operaciones.contarPorVacuna().containsKey("COVID-19"));
	}
}
