package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VentanaInicio extends JFrame {

	private JButton btnIniciarSesion;
	private JButton btnCrearCuenta;
	private JButton btnAdministrador;

	private JTextField campoUsuario;
	private JPasswordField campoContrasenya;

	private JLabel textoUsuario;
	private JLabel textoContrasenya;
	private JLabel textoCrearCuenta;

	private ImageIcon imagenFondo;
	private Image ajustar;
	private JLabel fondo;

	public VentanaInicio() {
		incializarComponentes();
	}

	public void incializarComponentes() {

		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(10, 10, 800, 400);
		this.setTitle("Inicio de sesión");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		imagenFondo = new ImageIcon(getClass().getResource("/VentanaInicio.png"));
		ajustar = imagenFondo.getImage();
		fondo = new JLabel(new ImageIcon(ajustar));
		fondo.setBounds(0, 0, 800, 400);
		this.setContentPane(fondo);
		fondo.setLayout(null);

		btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setFont(new Font("Gotham Rounded", Font.BOLD, 15));
		btnIniciarSesion.setBounds(305, 217, 149, 35);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setBorderPainted(false);
		fondo.add(btnIniciarSesion);

		// Crear cuenta

		btnCrearCuenta = new JButton("Crear");
		btnCrearCuenta.setFont(new Font("Gotham Rounded", Font.BOLD, 15));
		btnCrearCuenta.setBounds(339, 292, 114, 35);
		btnCrearCuenta.setContentAreaFilled(false);
		btnCrearCuenta.setFocusPainted(false);
		btnCrearCuenta.setOpaque(false);
		btnCrearCuenta.setBorderPainted(false);
		fondo.add(btnCrearCuenta);

		textoCrearCuenta = new JLabel("¿No tienes cuenta? Crea una aqui: ");
		textoCrearCuenta.setFont(new Font("Gotham Rounded", Font.BOLD, 14));
		textoCrearCuenta.setBounds(260, 250, 250, 40);
		fondo.add(textoCrearCuenta);

		// Usuario

		textoUsuario = new JLabel("Usuario");
		textoUsuario.setFont(new Font("Gotham Rounded", Font.BOLD, 15));
		textoUsuario.setBounds(285, 117, 70, 30);
		fondo.add(textoUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Gotham Rounded", Font.BOLD, 15));
		campoUsuario.setBounds(395, 120, 90, 27);
		campoUsuario.setOpaque(false);
		campoUsuario.setBorder(null);
		fondo.add(campoUsuario);

		// contraseña

		textoContrasenya = new JLabel("Contraseña");
		textoContrasenya.setFont(new Font("Gotham Rounded", Font.BOLD, 15));
		textoContrasenya.setBounds(270, 170, 90, 30);
		fondo.add(textoContrasenya);

		campoContrasenya = new JPasswordField();
		campoContrasenya.setFont(new Font("Gotham Rounded", Font.BOLD, 15));
		campoContrasenya.setBounds(395, 170, 90, 27);
		campoContrasenya.setOpaque(false);
		campoContrasenya.setBorder(null);
		fondo.add(campoContrasenya);

		// admin

		btnAdministrador = new JButton("Admin");
		btnAdministrador.setFont(new Font("Gotham Rounded", Font.BOLD, 10));
		btnAdministrador.setBounds(596, 34, 110, 25);
		btnAdministrador.setContentAreaFilled(false);
		btnAdministrador.setFocusPainted(false);
		btnAdministrador.setOpaque(false);
		btnAdministrador.setBorderPainted(false);
		fondo.add(btnAdministrador);

	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnCrearCuenta() {
		return btnCrearCuenta;
	}

	public void setBtnCrearCuenta(JButton btnCrearCuenta) {
		this.btnCrearCuenta = btnCrearCuenta;
	}

	public JButton getBtnAdministrador() {
		return btnAdministrador;
	}

	public void setBtnAdministrador(JButton btnAdministrador) {
		this.btnAdministrador = btnAdministrador;
	}

	public JTextField getCampoUsuario() {
		return campoUsuario;
	}

	public void setCampoUsuario(JTextField campoUsuario) {
		this.campoUsuario = campoUsuario;
	}

	public JPasswordField getCampoContrasenya() {
		return campoContrasenya;
	}

	public void setCampoContrasenya(JPasswordField campoContrasenya) {
		this.campoContrasenya = campoContrasenya;
	}

	public JLabel getTextoUsuario() {
		return textoUsuario;
	}

	public void setTextoUsuario(JLabel textoUsuario) {
		this.textoUsuario = textoUsuario;
	}

	public JLabel getTextoContraseya() {
		return textoContrasenya;
	}

	public void setTextoContrasenya(JLabel textoContrasenya) {
		this.textoContrasenya = textoContrasenya;
	}

	public JLabel getTextoCrearCuenta() {
		return textoCrearCuenta;
	}

	public void setTextoCrearCuenta(JLabel textoCrearCuenta) {
		this.textoCrearCuenta = textoCrearCuenta;
	}

	public ImageIcon getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(ImageIcon imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	public Image getAjustar() {
		return ajustar;
	}

	public void setAjustar(Image ajustar) {
		this.ajustar = ajustar;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	class RoundedBorder implements Border {
		private int radius;

		RoundedBorder(int radius) {
			this.radius = radius;
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
		}

		@Override
		public boolean isBorderOpaque() {
			return false;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
		}
	}

}
