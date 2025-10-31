package co.edu.unbosque.view;

import javax.swing.*;
import java.util.Calendar;

public class VentanaEdad extends JFrame {

	private JComboBox<Integer> comboDia;
	private JComboBox<String> comboMes;
	private JComboBox<Integer> comboAnio;
	private JButton btnIngresar;
	private JLabel lblTitulo;

	public VentanaEdad() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Ingreso de Fecha de Nacimiento");
		setSize(400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);

		lblTitulo = new JLabel("Seleccione su fecha de nacimiento:");
		lblTitulo.setBounds(80, 20, 300, 25);
		add(lblTitulo);

		comboDia = new JComboBox<>();
		for (int i = 1; i <= 31; i++) {
			comboDia.addItem(i);
		}
		comboDia.setBounds(50, 70, 80, 25);
		add(comboDia);

		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		comboMes = new JComboBox<>(meses);
		comboMes.setBounds(150, 70, 100, 25);
		add(comboMes);

		comboAnio = new JComboBox<>();
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = anioActual; i >= 1920; i--) {
			comboAnio.addItem(i);
		}
		comboAnio.setBounds(270, 70, 80, 25);
		add(comboAnio);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(150, 130, 100, 30);
		add(btnIngresar);

	}

	public JComboBox<Integer> getComboDia() {
		return comboDia;
	}

	public void setComboDia(JComboBox<Integer> comboDia) {
		this.comboDia = comboDia;
	}

	public JComboBox<String> getComboMes() {
		return comboMes;
	}

	public void setComboMes(JComboBox<String> comboMes) {
		this.comboMes = comboMes;
	}

	public JComboBox<Integer> getComboAnio() {
		return comboAnio;
	}

	public void setComboAnio(JComboBox<Integer> comboAnio) {
		this.comboAnio = comboAnio;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

}
