package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class Administrador extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2936940640412337366L;
	private Properties prop;
	private String companyia;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(String companyia) {
		super();
		this.companyia = companyia;
	}

	public Administrador(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion, String companyia) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);
		this.companyia = companyia;
	}

	public Administrador(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);
		// TODO Auto-generated constructor stub
	}

	public String getCompanyia() {
		return companyia;
	}

	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return prop.getProperty("model_admin_tostring_admin") + super.toString(
				prop.getProperty("model_persona_tostring_nombre"), prop.getProperty("model_persona_tostring_alias"),
				prop.getProperty("model_persona_tostring_cedula"), prop.getProperty("model_persona_tostring_correo"),
				prop.getProperty("model_persona_tostring_contrasenya"),
				prop.getProperty("model_persona_tostring_codigoverificacion"))
				+ prop.getProperty("model_admin_tostring_companyia") + companyia + "\n";
	}

}