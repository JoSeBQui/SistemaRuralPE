package menuPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaPaciente extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JornadaVacunacion jornada;

	private JPanel panelPrincipal;
	private JLabel lblTitulo;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JLabel lblMotivo;
	private JTextField txtMotivo;
	private JLabel lblVacuna;
	private JTextField txtVacuna;
	private JButton btnGuardar;
	private JLabel lblMensaje;
	private JTextArea txtResultado;
	private JScrollPane scrollResultado;

	public VentanaPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("REGISTRO RAPIDO DE VACUNACION");
		setBounds(250, 150, 650, 600);

		setLocationRelativeTo(null);

		jornada = JornadaVacunacion.getInstancia();

		iniciarComponentes();

		mostrarReporteDetallado();
	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();

		panelPrincipal.setBackground(new Color(229, 229, 229));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		{
			lblTitulo = new JLabel("BRIGADA RURAL");
			lblTitulo.setBackground(Color.black);
			lblTitulo.setForeground(Color.white);
			lblTitulo.setOpaque(true);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblTitulo.setBounds(0, 0, 640, 45);
			panelPrincipal.add(lblTitulo);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDni.setBounds(30, 62, 150, 25);
			panelPrincipal.add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDni.setBounds(190, 60, 150, 28);
			panelPrincipal.add(txtDni);
			txtDni.setColumns(10);
		}
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombres.setBounds(30, 100, 150, 25);
			panelPrincipal.add(lblNombres);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNombres.setBounds(190, 98, 400, 28);
			panelPrincipal.add(txtNombres);
			txtNombres.setColumns(10);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblApellidos.setBounds(30, 138, 150, 25);
			panelPrincipal.add(lblApellidos);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtApellidos.setBounds(190, 136, 400, 28);
			panelPrincipal.add(txtApellidos);
			txtApellidos.setColumns(10);
		}
		{
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEdad.setBounds(30, 176, 150, 25);
			panelPrincipal.add(lblEdad);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtEdad.setBounds(190, 174, 80, 28);
			panelPrincipal.add(txtEdad);
			txtEdad.setColumns(10);
		}
		{
			lblMotivo = new JLabel("Motivo / condicion:");
			lblMotivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMotivo.setBounds(30, 214, 150, 25);
			panelPrincipal.add(lblMotivo);
		}
		{
			txtMotivo = new JTextField();
			txtMotivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtMotivo.setBounds(190, 212, 400, 28);
			panelPrincipal.add(txtMotivo);
			txtMotivo.setColumns(10);
		}
		{
			lblVacuna = new JLabel("Vacuna:");
			lblVacuna.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblVacuna.setBounds(30, 252, 150, 25);
			panelPrincipal.add(lblVacuna);
		}
		{
			txtVacuna = new JTextField();
			txtVacuna.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtVacuna.setBounds(190, 250, 400, 28);
			panelPrincipal.add(txtVacuna);
			txtVacuna.setColumns(10);
		}
		{
			btnGuardar = new JButton("Registrar persona");
			btnGuardar.addActionListener(this);
			btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGuardar.setBounds(190, 294, 200, 35);
			panelPrincipal.add(btnGuardar);
		}
		{
			lblMensaje = new JLabel(" ");
			lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblMensaje.setBounds(30, 338, 580, 22);
			panelPrincipal.add(lblMensaje);
		}
		{
			txtResultado = new JTextArea();
			txtResultado.setEditable(false);
			txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 11));
			scrollResultado = new JScrollPane(txtResultado);
			scrollResultado.setBounds(30, 366, 580, 190);
			panelPrincipal.add(scrollResultado);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}

	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		String dni = txtDni.getText().trim();
		String nombres = txtNombres.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		String motivo = txtMotivo.getText().trim();
		String vacuna = txtVacuna.getText().trim();
		Operaciones operaciones = jornada.getOperaciones();

		try {
			int edad = Integer.parseInt(txtEdad.getText().trim());

			if (dni.length() != 8) {
				mostrarMensaje("ERROR: el DNI debe tener 8 digitos.", true);
				return;
			}

			if (nombres.isEmpty() || apellidos.isEmpty() || motivo.isEmpty() || vacuna.isEmpty()) {
				mostrarMensaje("ERROR: complete nombres, apellidos, motivo y vacuna.", true);
				return;
			}

			if (operaciones.existeRegistro(dni)) {
				mostrarMensaje("ERROR: esta persona ya fue registrada en esta jornada.", true);
				return;
			}

			Paciente nuevoPaciente = new Paciente(dni, nombres, apellidos, edad, motivo, vacuna);
			nuevoPaciente.marcarComoVacunado();
			jornada.aplicarDosis();
			operaciones.registrar(nuevoPaciente);

			mostrarMensaje("REGISTRO EXITOSO - Dosis disponibles restantes: "
					+ jornada.getDosisDisponibles(), false);
			mostrarReporteDetallado();

			txtDni.setText("");
			txtNombres.setText("");
			txtApellidos.setText("");
			txtEdad.setText("");
			txtMotivo.setText("");
			txtVacuna.setText("");
		} catch (NumberFormatException ex) {
			mostrarMensaje("ERROR: la edad debe ser un numero.", true);
		} catch (IllegalStateException ex) {
			mostrarMensaje("ERROR: " + ex.getMessage(), true);
		}
	}

	private void mostrarReporteDetallado() {
		Reporte reporte = ReporteFactory.crearReporte("detallado", jornada.getOperaciones());
		txtResultado.setText(reporte.generar());
	}

	private void mostrarMensaje(String texto, boolean esError) {
		lblMensaje.setForeground(esError ? new Color(180, 0, 0) : new Color(0, 110, 0));
		lblMensaje.setText(texto);
	}
}
