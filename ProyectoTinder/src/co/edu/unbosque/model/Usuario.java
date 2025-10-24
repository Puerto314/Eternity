package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class Usuario extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7714402553503730278L;
	private Properties prop;
	private String edad;
	private float estatura;
	private String fotoPerfil;
	private int meGusta;
	private boolean estaDisponible;
	private String lugar;
	private boolean esHombre;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String edad, float estatura, String fotoPerfil, int meGusta, boolean estaDisponible, String lugar,
			boolean esHombre) {
		super();
		this.edad = edad;
		this.estatura = estatura;
		this.fotoPerfil = fotoPerfil;
		this.meGusta = meGusta;
		this.estaDisponible = estaDisponible;
		this.lugar = lugar;
		this.esHombre = esHombre;
	}

	public Usuario(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion, String edad, float estatura, String fotoPerfil, int meGusta,
			boolean estaDisponible, String lugar, boolean esHombre) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);
		this.edad = edad;
		this.estatura = estatura;
		this.fotoPerfil = fotoPerfil;
		this.meGusta = meGusta;
		this.estaDisponible = estaDisponible;
		this.lugar = lugar;
		this.esHombre = esHombre;
	}

	public Usuario(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);
		// TODO Auto-generated constructor stub
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public int getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}

	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public boolean isEsHombre() {
		return esHombre;
	}

	public void setEsHombre(boolean esHombre) {
		this.esHombre = esHombre;
	}

	public String toString(/* Propio de usuario */String usuarioStr, String edadStr, String estaturaStr,
			String fotoPerfStr, String meGustaStr, String estaDisponibleStr, String lugarStr,
			String sexStr /* Super, persona */, String afirmacionStr, String negacionStr, String esHombreStr,
			String esMujerStr, String nombreStr, String aliasStr, String cedulaStr, String correoStr,
			String contrasenyaStr, String codVerifStr) {

		String esDisp = "";

		if (estaDisponible) {
			esDisp = afirmacionStr;
		} else {
			esDisp = negacionStr;
		}
		String sex = "";
		if (esHombre) {
			sex = esHombreStr;
		} else {
			sex = esMujerStr;
		}
		return usuarioStr + super.toString(nombreStr, aliasStr, cedulaStr, correoStr, contrasenyaStr, codVerifStr)
				+ edadStr + edad + estaturaStr + estatura + fotoPerfStr + fotoPerfil + meGustaStr + meGusta
				+ estaDisponibleStr + esDisp + lugarStr + lugar + sexStr + sex + "\n";
	}

}