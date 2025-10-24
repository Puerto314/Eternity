package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private JLabel textoCorreo;
	private JLabel textoEstatura;
	private JLabel textoIngresos; // opcionales
	private JLabel textoDivorciada; // opcionales
	private JLabel textoSexo;

	private JTextField campoNombre;
	private JTextField campoAlias;
	private JTextField campoEdad;
	private JTextField campoCorreo;
	private JTextField campoEstatura;
	private JTextField campoIngreso; // opcionales
	private JTextField campoDivorciada; // opcionales
	private JTextField campoDefault;

	private ImageIcon fondoVentana;
	private Image ajustar;

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

		fondoVentana = new ImageIcon(getClass().getResource("/co/edu/unbosque/view/VentanaRegistro.png"));
		ajustar = fondoVentana.getImage();
		fondo = new JLabel(new ImageIcon(ajustar));
		fondo.setBounds(0, 0, 800, 400);
		this.setContentPane(fondo);
		fondo.setLayout(null);

		JLabel textoUsuario = new JLabel("Usuario");
		textoUsuario.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoUsuario.setBounds(40, 150, 130, 20);
		fondo.add(textoUsuario);

		campoAlias = new JTextField();
		campoAlias.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoAlias.setBounds(200, 150, 100, 20);
		campoAlias.setOpaque(false);
		campoAlias.setBorder(null);
		fondo.add(campoAlias);

		JLabel textoContrasena = new JLabel("Contraseña");
		textoContrasena.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoContrasena.setBounds(40, 195, 130, 20);
		fondo.add(textoContrasena);

		JPasswordField campoContrasena = new JPasswordField();
		campoContrasena.setFont(new Font("Gotham Rounded", Font.PLAIN, 18));
		campoContrasena.setBounds(200, 200, 100, 20);
		campoContrasena.setOpaque(false);
		campoContrasena.setBorder(null);
		fondo.add(campoContrasena);

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

		textoEdad = new JLabel("Edad");
		textoEdad.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoEdad.setBounds(320, 121, 100, 20);
		fondo.add(textoEdad);

		campoEdad = new JTextField();
		campoEdad.setFont(new Font("Gotham Rounded", Font.BOLD, 18));
		campoEdad.setBounds(445, 133, 80, 20);
		campoEdad.setOpaque(false);
		campoEdad.setBorder(null);
		fondo.add(campoEdad);

		textoEstatura = new JLabel("Estatura");
		textoEstatura.setFont(new Font("Gotham Rounded", Font.BOLD, 20));
		textoEstatura.setBounds(322, 170, 98, 20);
		fondo.add(textoEstatura);

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
		textoCorreo.setBounds(320, 203, 100, 20);
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

	public JTextField getCampoEdad() {
		return campoEdad;
	}

	public void setCampoEdad(JTextField campoEdad) {
		this.campoEdad = campoEdad;
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
