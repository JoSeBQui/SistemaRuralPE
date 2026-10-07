package menuPrincipal;

public class ReporteResumen extends Reporte {
	public ReporteResumen(Operaciones operaciones) {
		super(operaciones);
	}

	@Override
	public String generar() {
		StringBuilder texto = new StringBuilder();
		texto.append("RESUMEN DE LA JORNADA\n\n");
		texto.append("Total de personas registradas: ").append(operaciones.total()).append("\n");
		texto.append("Vacunados: ").append(operaciones.filtrarVacunados().size()).append("\n");
		texto.append("Pendientes: ").append(operaciones.filtrarPendientes().size()).append("\n");
		texto.append("\nDosis aplicadas por vacuna:\n");
		operaciones.contarPorVacuna().forEach((vacuna, cantidad) ->
				texto.append("  - ").append(vacuna).append(": ").append(cantidad).append("\n"));
		try {
			texto.append("Edad promedio: ").append(String.format("%.1f", operaciones.edadPromedio()));
		} catch (ArithmeticException ex) {
			texto.append("Edad promedio: sin datos aun");
		}
		return texto.toString();
	}
}
