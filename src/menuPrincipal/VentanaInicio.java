package menuPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInicio extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JButton btnEntrar;

	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SISTEMA RURAL PE");
		setBounds(250, 150, 650, 420);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 229, 229));
		panel.setLayout(null);
		setContentPane(panel);

		lblTitulo = new JLabel("BRIGADA RURAL");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(0, 0, 640, 45);
		panel.add(lblTitulo);

		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(235, 140, 170, 50);
		panel.add(btnEntrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEntrar) {
			do_btnEntrar_actionPerformed(e);
		}
	}

	protected void do_btnEntrar_actionPerformed(ActionEvent e) {
		new VentanaPaciente().setVisible(true);
		dispose();
	}
}
