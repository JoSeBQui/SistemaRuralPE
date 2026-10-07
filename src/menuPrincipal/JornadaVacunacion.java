package menuPrincipal;

public class JornadaVacunacion {
	private static JornadaVacunacion instancia;

	private String nombreBrigada;
	private String lugar;
	private int dosisDisponibles;
	private Operaciones operaciones;

	private JornadaVacunacion() {
		this.nombreBrigada = "Brigada de Vacunacion Rural";
		this.lugar = "Caserio Alto Peru - San Ignacio, Cajamarca";
		this.dosisDisponibles = 50;
		this.operaciones = new Operaciones();
	}

	public static JornadaVacunacion getInstancia() {
		if (instancia == null) {
			instancia = new JornadaVacunacion();
		}
		return instancia;
	}

	public Operaciones getOperaciones() {
		return operaciones;
	}

	public String getNombreBrigada() {
		return nombreBrigada;
	}

	public String getLugar() {
		return lugar;
	}

	public int getDosisDisponibles() {
		return dosisDisponibles;
	}

	public void aplicarDosis() {
		if (dosisDisponibles <= 0) {
			throw new IllegalStateException("No quedan dosis disponibles en esta jornada");
		}
		dosisDisponibles--;
	}
}
