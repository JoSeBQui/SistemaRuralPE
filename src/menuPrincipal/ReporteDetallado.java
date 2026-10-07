package menuPrincipal;

public class ReporteDetallado extends Reporte {
	public ReporteDetallado(Operaciones operaciones) {
		super(operaciones);
	}

	@Override
	public String generar() {
		StringBuilder texto = new StringBuilder();
		texto.append("REPORTE DETALLADO DE LA JORNADA\n");
		texto.append(String.format("%-24s | %-9s | %-14s | %s%n", "NOMBRE", "DNI", "VACUNA", "MOTIVO"));
		texto.append("-----------------------------------------------------------------\n");
		for (String linea : operaciones.generarLineasReporte()) {
			texto.append(linea).append("\n");
		}
		return texto.toString();
	}
}
