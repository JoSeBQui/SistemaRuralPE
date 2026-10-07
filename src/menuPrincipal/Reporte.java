package menuPrincipal;

public abstract class Reporte {
	protected Operaciones operaciones;

	public Reporte(Operaciones operaciones) {
		this.operaciones = operaciones;
	}

	public abstract String generar();
}
