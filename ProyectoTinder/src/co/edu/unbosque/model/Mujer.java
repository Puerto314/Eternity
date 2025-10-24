package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class Mujer extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6815538039382944723L;
	private Properties prop;
	private boolean estaDivorciada;

	public Mujer() {
		// TODO Auto-generated constructor stub
	}

	public Mujer(boolean estaDivorciada) {
		super();
		this.estaDivorciada = estaDivorciada;
	}

	public Mujer(String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad, String lugar,
			boolean sexo, boolean estaDivorciada) {
		super(edad, estatura, fotoPerfil, meGusta, disponibilidad, lugar, sexo);
		this.estaDivorciada = estaDivorciada;
	}

	public Mujer(String nombre, String alias, long cedula, String correo, String contrasenya, String codigoVerificacion,
			String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad, String lugar,
			boolean sexo, boolean estaDivorciada) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion, edad, estatura, fotoPerfil, meGusta,
				disponibilidad, lugar, sexo);
		this.estaDivorciada = estaDivorciada;
	}

	public Mujer(String nombre, String alias, long cedula, String correo, String contrasenya, String codigoVerificacion,
			boolean estaDivorciada) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);

		this.estaDivorciada = estaDivorciada;
	}

	public Mujer(String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad, String lugar,
			boolean sexo) {
		super(edad, estatura, fotoPerfil, meGusta, disponibilidad, lugar, sexo);
		// TODO Auto-generated constructor stub
	}

	public Mujer(String nombre, String alias, long cedula, String correo, String contrasenya, String codigoVerificacion,
			String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad, String lugar,
			boolean sexo) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion, edad, estatura, fotoPerfil, meGusta,
				disponibilidad, lugar, sexo);
		// TODO Auto-generated constructor stub
	}

	public Mujer(String nombre, String alias, long cedula, String correo, String contrasenya,
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

	public boolean isEstaDivorciada() {
		return estaDivorciada;
	}

	public void setEstaDivorciada(boolean estaDivorciada) {
		this.estaDivorciada = estaDivorciada;
	}

	@Override
	public String toString() {
		String div = "";
		if (estaDivorciada) {
			div = prop.getProperty("palabra_si");
		} else {
			div = prop.getProperty("palabra_no");
		}

		return prop.getProperty("model_mujer_tostring_mujer") + super.toString(
				prop.getProperty("model_user_tostring_user"), prop.getProperty("model_user_tostring_edad"),
				prop.getProperty("model_user_tostring_estatura"), prop.getProperty("model_user_tostring_pfp"),
				prop.getProperty("model_user_tostring_likes"), prop.getProperty("model_user_tostring_estadisponible"),
				prop.getProperty("model_user_tostring_lugar"), prop.getProperty("model_user_tostring_sexo"),
				prop.getProperty("palabra_si"), prop.getProperty("palabra_no"),
				prop.getProperty("model_user_tostring_eshombre"), prop.getProperty("model_user_tostring_esmujer"),
				prop.getProperty("model_persona_tostring_nombre"), prop.getProperty("model_persona_tostring_alias"),
				prop.getProperty("model_persona_tostring_cedula"), prop.getProperty("model_persona_tostring_correo"),
				prop.getProperty("model_admin_tostring_companyia"),
				prop.getProperty("model_persona_tostring_codigoverificacion"))
				+ prop.getProperty("model_mujer_tostring_divor") + div + "\n";
	}

}