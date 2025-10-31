package co.edu.unbosque.view;

import java.util.Properties;

public class ViewFacade {

	private VentanaInicio ventanaInicio;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaRegistro ventanaRegistro;
	private VentanaEdad ventanaEdad;

	public ViewFacade() {
		ventanaInicio = new VentanaInicio();
		ventanaPrincipal = new VentanaPrincipal();
		ventanaRegistro = new VentanaRegistro();
		ventanaEdad = new VentanaEdad();

	}

	public VentanaInicio getVentanaInicio() {
		return ventanaInicio;
	}

	public void setVentanaInicio(VentanaInicio ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public VentanaRegistro getVentanaRegistro() {
		return ventanaRegistro;
	}

	public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
		this.ventanaRegistro = ventanaRegistro;
	}

	public void cargarPropiedades(Properties prop) {
		// TODO Auto-generated method stub

	}

	public VentanaEdad getVentanaEdad() {
		return ventanaEdad;
	}

	public void setVentanaEdad(VentanaEdad ventanaEdad) {
		this.ventanaEdad = ventanaEdad;
	}

}
