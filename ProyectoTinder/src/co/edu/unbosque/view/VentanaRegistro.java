package co.edu.unbosque.view;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

import java.awt.Component;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VentanaRegistro extends JFrame {

	private JLabel fondo;

	private JButton btnCrear;
	private JButton btnVolver;

	private JLabel textoNombre;
	private JLabel textoAlias;
	private JLabel textoEdad;
	private JLabel textoEdadDos;
	private JLabel textoCorreo;
	private JLabel textoEstatura;
	private JLabel textoEstaturaDos;
	private JLabel textoIngresos; // opcionales
	private JLabel textoDivorciada; // opcionales
	private JLabel textoSexo;
	private JLabel textoContrasenya;
	private JTextField campoNombre;
	private JTextField campoAlias;
	private JTextField campoCorreo;
	private JTextField campoEstatura;
	private JTextField campoIngreso; // opcionales
	private JTextField campoDivorciada; // opcionales
	private JTextField campoDefault;
	private JTextField campoContrasenya;

	private ImageIcon fondoVentana;
	private Image ajustar;

	private JButton botonSeleccionarImagen;
	private JButton botonEdad;
	private JLabel labelImagenSeleccionada;

	private JComboBox<String> listaSexos;

	public VentanaRegistro() {

		inicializarComponentes();

	}

	public void inicializarComponentes() {

		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(0, 0, 800, 400);
		this.setTitle("Registro usuario");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		fondoVentana = new ImageIcon(getClass().getResource("/VentanaRegistro.png"));
		ajustar = fondoVentana.getImage();
		fondo = new JLabel(new ImageIcon(ajustar));
		fondo.setBounds(0, 0, 800, 400);
		this.setContentPane(fondo);
		fondo.setLayout(null);

		textoAlias = new JLabel("Usuario");
		textoAlias.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoAlias.setBounds(60, 145, 130, 20);
		fondo.add(textoAlias);

		campoAlias = new JTextField();
		campoAlias.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoAlias.setBounds(200, 150, 100, 20);
		campoAlias.setOpaque(false);
		campoAlias.setBorder(null);
		fondo.add(campoAlias);

		textoContrasenya = new JLabel("Contraseña");
		textoContrasenya.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoContrasenya.setBounds(40, 195, 130, 20);
		fondo.add(textoContrasenya);

		campoContrasenya = new JPasswordField();
		campoContrasenya.setFont(new Font("Gotham Rounded", Font.PLAIN, 18));
		campoContrasenya.setBounds(200, 200, 100, 20);
		campoContrasenya.setOpaque(false);
		campoContrasenya.setBorder(null);
		fondo.add(campoContrasenya);

		textoSexo = new JLabel("Sexo");
		textoSexo.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoSexo.setBounds(40, 245, 130, 30);
		fondo.add(textoSexo);

		listaSexos = new JComboBox<>();
		listaSexos.addItem("Hombre");
		listaSexos.addItem("Mujer");
		listaSexos.setFont(new Font("Gotham Rounded", Font.BOLD, 14));
		listaSexos.setBounds(200, 250, 100, 30);
		listaSexos.setOpaque(false);
		listaSexos.setBorder(null);
		listaSexos.setBackground(new Color(0, 0, 0, 0));
		fondo.add(listaSexos);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Gotham Rounded", Font.BOLD, 10));
		btnVolver.setBounds(37, 290, 75, 49);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		fondo.add(btnVolver);

		textoNombre = new JLabel("Nombre");
		textoNombre.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoNombre.setBounds(320, 90, 100, 20);
		fondo.add(textoNombre);

		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoNombre.setBounds(445, 90, 80, 20);
		campoNombre.setOpaque(false);
		campoNombre.setBorder(null);
		fondo.add(campoNombre);

		textoEdad = new JLabel("¿Cuando");
		textoEdad.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoEdad.setBounds(315, 118, 100, 25);
		fondo.add(textoEdad);

		textoEdadDos = new JLabel("nació?");
		textoEdadDos.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoEdadDos.setBounds(331, 143, 120, 20);
		fondo.add(textoEdadDos);

		botonEdad = new JButton("   Clic aquí") {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				super.paintComponent(g2);
				g2.dispose();
			}

			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2.dispose();
			}
		};

		botonEdad.setFont(new Font("Gotham Rounded", Font.BOLD, 16));
		botonEdad.setBounds(412, 126, 120, 32);
		botonEdad.setContentAreaFilled(false);
		botonEdad.setFocusPainted(false);
		botonEdad.setOpaque(false);
		botonEdad.setBorderPainted(false);
		botonEdad.setForeground(Color.BLACK);
		fondo.add(botonEdad);

		textoEstatura = new JLabel("Estatura");
		textoEstatura.setFont(new Font("Gotham Rounded", Font.BOLD, 19));
		textoEstatura.setBounds(325, 168, 98, 20);
		fondo.add(textoEstatura);

		textoEstaturaDos = new JLabel("(cm)");
		textoEstaturaDos.setFont(new Font("Gotham Rounded", Font.BOLD, 19));
		textoEstaturaDos.setBounds(343, 185, 98, 20);
		fondo.add(textoEstaturaDos);

		campoEstatura = new JTextField();
		campoEstatura.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoEstatura.setBounds(447, 172, 80, 20);
		campoEstatura.setOpaque(false);
		campoEstatura.setBorder(null);
		fondo.add(campoEstatura);

		textoIngresos = new JLabel("Ingresos");
		textoIngresos.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoIngresos.setBounds(320, 260, 120, 20);
		textoIngresos.setVisible(false);
		fondo.add(textoIngresos);

		campoIngreso = new JTextField();
		campoIngreso.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoIngreso.setBounds(447, 263, 80, 20);
		campoIngreso.setVisible(false);
		campoIngreso.setOpaque(false);
		campoIngreso.setBorder(null);
		fondo.add(campoIngreso);

		textoDivorciada = new JLabel("Divorciada");
		textoDivorciada.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoDivorciada.setBounds(320, 260, 120, 20);
		textoDivorciada.setVisible(false);
		fondo.add(textoDivorciada);

		campoDivorciada = new JTextField();
		campoDivorciada.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoDivorciada.setBounds(445, 262, 80, 20);
		campoDivorciada.setVisible(false);
		campoDivorciada.setOpaque(false);
		campoDivorciada.setBorder(null);
		fondo.add(campoDivorciada);

		campoDefault = new JTextField("");
		campoDefault.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoDefault.setBounds(445, 262, 80, 20);
		campoDefault.setEditable(false);
		campoDefault.setVisible(true);
		campoDefault.setOpaque(false);
		campoDefault.setBorder(null);
		fondo.add(campoDefault);

		textoCorreo = new JLabel("Correo");
		textoCorreo.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoCorreo.setBounds(330, 210, 100, 20);
		fondo.add(textoCorreo);

		campoCorreo = new JTextField();
		campoCorreo.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoCorreo.setBounds(443, 217, 80, 20);
		campoCorreo.setOpaque(false);
		campoCorreo.setBorder(null);
		fondo.add(campoCorreo);

		btnCrear = new JButton("Confirmar");
		btnCrear.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		btnCrear.setBounds(570, 240, 185, 45);
		btnCrear.setContentAreaFilled(false);
		btnCrear.setFocusPainted(false);
		btnCrear.setOpaque(false);
		btnCrear.setBorderPainted(false);
		fondo.add(btnCrear);

		botonSeleccionarImagen = new JButton();
		botonSeleccionarImagen.setBounds(737, 203, 25, 25);
		botonSeleccionarImagen.setBackground(Color.WHITE);
		botonSeleccionarImagen.setForeground(Color.BLACK);
		botonSeleccionarImagen.setFocusPainted(false);
		botonSeleccionarImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		fondo.add(botonSeleccionarImagen);

		labelImagenSeleccionada = new JLabel("Seleccione una imagen ->");
		labelImagenSeleccionada.setBounds(560, 200, 170, 30);
		labelImagenSeleccionada.setFont(new Font("Arial", Font.PLAIN, 14));
		fondo.add(labelImagenSeleccionada);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JLabel getTextoNombre() {
		return textoNombre;
	}

	public void setTextoNombre(JLabel textoNombre) {
		this.textoNombre = textoNombre;
	}

	public JLabel getTextoAlias() {
		return textoAlias;
	}

	public void setTextoAlias(JLabel textoAlias) {
		this.textoAlias = textoAlias;
	}

	public JLabel getTextoEdad() {
		return textoEdad;
	}

	public void setTextoEdad(JLabel textoEdad) {
		this.textoEdad = textoEdad;
	}

	public JLabel getTextoEdadDos() {
		return textoEdadDos;
	}

	public void setTextoEdadDos(JLabel textoEdadDos) {
		this.textoEdadDos = textoEdadDos;
	}

	public JLabel getTextoCorreo() {
		return textoCorreo;
	}

	public void setTextoCorreo(JLabel textoCorreo) {
		this.textoCorreo = textoCorreo;
	}

	public JLabel getTextoEstatura() {
		return textoEstatura;
	}

	public void setTextoEstatura(JLabel textoEstatura) {
		this.textoEstatura = textoEstatura;
	}

	public JLabel getTextoIngresos() {
		return textoIngresos;
	}

	public void setTextoIngresos(JLabel textoIngresos) {
		this.textoIngresos = textoIngresos;
	}

	public JLabel getTextoDivorciada() {
		return textoDivorciada;
	}

	public void setTextoDivorciada(JLabel textoDivorciada) {
		this.textoDivorciada = textoDivorciada;
	}

	public JLabel getTextoSexo() {
		return textoSexo;
	}

	public void setTextoSexo(JLabel textoSexo) {
		this.textoSexo = textoSexo;
	}

	public JLabel getTextoContrasenya() {
		return textoContrasenya;
	}

	public void setTextoContrasenya(JLabel textoContrasenya) {
		this.textoContrasenya = textoContrasenya;
	}

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	public JTextField getCampoAlias() {
		return campoAlias;
	}

	public void setCampoAlias(JTextField campoAlias) {
		this.campoAlias = campoAlias;
	}

	public JTextField getCampoCorreo() {
		return campoCorreo;
	}

	public void setCampoCorreo(JTextField campoCorreo) {
		this.campoCorreo = campoCorreo;
	}

	public JTextField getCampoEstatura() {
		return campoEstatura;
	}

	public void setCampoEstatura(JTextField campoEstatura) {
		this.campoEstatura = campoEstatura;
	}

	public JTextField getCampoIngreso() {
		return campoIngreso;
	}

	public void setCampoIngreso(JTextField campoIngreso) {
		this.campoIngreso = campoIngreso;
	}

	public JTextField getCampoDivorciada() {
		return campoDivorciada;
	}

	public void setCampoDivorciada(JTextField campoDivorciada) {
		this.campoDivorciada = campoDivorciada;
	}

	public JTextField getCampoDefault() {
		return campoDefault;
	}

	public void setCampoDefault(JTextField campoDefault) {
		this.campoDefault = campoDefault;
	}

	public JTextField getCampoContrasenya() {
		return campoContrasenya;
	}

	public void setCampoContrasenya(JTextField campoContrasenya) {
		this.campoContrasenya = campoContrasenya;
	}

	public ImageIcon getFondoVentana() {
		return fondoVentana;
	}

	public void setFondoVentana(ImageIcon fondoVentana) {
		this.fondoVentana = fondoVentana;
	}

	public Image getAjustar() {
		return ajustar;
	}

	public void setAjustar(Image ajustar) {
		this.ajustar = ajustar;
	}

	public JButton getBotonSeleccionarImagen() {
		return botonSeleccionarImagen;
	}

	public void setBotonSeleccionarImagen(JButton botonSeleccionarImagen) {
		this.botonSeleccionarImagen = botonSeleccionarImagen;
	}

	public JButton getBotonEdad() {
		return botonEdad;
	}

	public void setBotonEdad(JButton botonEdad) {
		this.botonEdad = botonEdad;
	}

	public JLabel getLabelImagenSeleccionada() {
		return labelImagenSeleccionada;
	}

	public void setLabelImagenSeleccionada(JLabel labelImagenSeleccionada) {
		this.labelImagenSeleccionada = labelImagenSeleccionada;
	}

	public JComboBox<String> getListaSexos() {
		return listaSexos;
	}

	public void setListaSexos(JComboBox<String> listaSexos) {
		this.listaSexos = listaSexos;
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
