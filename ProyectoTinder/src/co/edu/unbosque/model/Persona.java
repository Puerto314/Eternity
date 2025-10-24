package co.edu.unbosque.model;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2605090105710016709L;
	
	private String nombre;
	private String alias;
	private long cedula;
	private String correo;
	private String contrasenya;
	private String codigoVerificacion;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasenya = contrasenya;
		this.codigoVerificacion = codigoVerificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(String codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	
	public String toString(String nombreStr, String aliasStr, String cedulaStr, String correoStr, String contrasenyaStr, String codVerStr) {
		return nombreStr + nombre + aliasStr + alias + cedulaStr + cedula + correoStr + correo
				+ contrasenyaStr + contrasenya + codVerStr + codigoVerificacion + "]";
	}
	
	
	
	
}
