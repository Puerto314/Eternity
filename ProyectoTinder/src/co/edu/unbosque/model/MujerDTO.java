package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class MujerDTO extends Usuario  {

	private Properties prop;
	private boolean estaDivorciada;
	
	public MujerDTO() {
		// TODO Auto-generated constructor stub
	}

	public MujerDTO( boolean estaDivorciada) {
		super();
		this.estaDivorciada = estaDivorciada;
	}

	public MujerDTO(String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad,
			String lugar, boolean sexo, boolean estaDivorciada) {
		super(edad, estatura, fotoPerfil, meGusta, disponibilidad, lugar, sexo);
		this.estaDivorciada = estaDivorciada;
	}

	public MujerDTO(String nombre, String alias, long cedula, String correo, String contrasenya, String codigoVerificacion,
			 String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad,
			String lugar, boolean sexo, boolean estaDivorciada) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion, edad, estatura, fotoPerfil, meGusta,
				disponibilidad, lugar, sexo);
		this.estaDivorciada = estaDivorciada;
	}

	public MujerDTO(String nombre, String alias, long cedula, String correo, String contrasenya, String codigoVerificacion,
			 boolean estaDivorciada) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);
		
		this.estaDivorciada = estaDivorciada;
	}

	public MujerDTO( String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad,
			String lugar, boolean sexo) {
		super(edad, estatura, fotoPerfil, meGusta, disponibilidad, lugar, sexo);
		// TODO Auto-generated constructor stub
	}

	public MujerDTO(String nombre, String alias, long cedula, String correo, String contrasenya, String codigoVerificacion,
			 String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad,
			String lugar, boolean sexo) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion,edad, estatura, fotoPerfil, meGusta,
				disponibilidad, lugar, sexo);
		// TODO Auto-generated constructor stub
	}

	public MujerDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
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
		return "MujerDTO [prop=" + prop + ", estaDivorciada=" + estaDivorciada + "]";
	}
	
	
}