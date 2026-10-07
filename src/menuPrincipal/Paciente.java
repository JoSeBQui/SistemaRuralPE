package menuPrincipal;

public class Paciente {
	private String dni;
	private String nombres;
	private String apellidos;
	private int edad;
	private String motivoConsulta;
	private String vacuna;
	private boolean vacunado;

	public Paciente(String dni, String nombres, String apellidos, int edad, String motivoConsulta, String vacuna) {
		this.dni = dni;
		this.nombres = nombres.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.edad = edad;
		this.motivoConsulta = motivoConsulta;
		this.vacuna = vacuna;
		this.vacunado = false;
	}

	public String getDniEnmascarado() {
		if (dni == null || dni.length() < 8) {
			return "SIN DNI";
		}
		return dni.substring(0, 2) + "***" + dni.substring(5);
	}

	public String getDni() {
		return dni;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public String getVacuna() {
		return vacuna;
	}

	public String getNombreCompleto() {
		return nombres + " " + apellidos;
	}

	public boolean isVacunado() {
		return vacunado;
	}

	public void marcarComoVacunado() {
		this.vacunado = true;
	}

	@Override
	public String toString() {
		return String.format("%-24s | %-9s | %-14s | %s",
				getNombreCompleto(), getDniEnmascarado(), vacuna, motivoConsulta);
	}
}
