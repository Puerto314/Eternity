package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class AdministradorDTO extends Persona {

	private Properties prop;
	private String companyia;
	
	public AdministradorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdministradorDTO(String companyia) {
		super();
		this.companyia = companyia;
	}

	public AdministradorDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion, String companyia) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);
		this.companyia = companyia;
	}

	public AdministradorDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
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
		return "Admin" + super.toString() + "compañia" + companyia + "]";
	}
	
	
}