package menuPrincipal;

public class ReporteFactory {
	public static Reporte crearReporte(String tipo, Operaciones operaciones) {
		if (tipo.equalsIgnoreCase("detallado")) {
			return new ReporteDetallado(operaciones);
		}
		return new ReporteResumen(operaciones);
	}
}
