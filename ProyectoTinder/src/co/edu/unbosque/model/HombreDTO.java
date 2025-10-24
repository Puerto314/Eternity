package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class HombreDTO extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7096544807358879912L;
	/**
	 * 
	 */
	private Properties prop;
	private long salario;

	public HombreDTO() {
		// TODO Auto-generated constructor stub
	}

	public HombreDTO(long salario) {
		super();

		this.salario = salario;
	}

	public HombreDTO(String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad, String lugar,
			boolean sexo, long salario) {
		super(edad, estatura, fotoPerfil, meGusta, disponibilidad, lugar, sexo);

		this.salario = salario;
	}

	public HombreDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion, String edad, float estatura, String fotoPerfil, int meGusta,
			boolean disponibilidad, String lugar, boolean sexo, long salario) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion, edad, estatura, fotoPerfil, meGusta,
				disponibilidad, lugar, sexo);

		this.salario = salario;
	}

	public HombreDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion, long salario) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion);

		this.salario = salario;
	}

	public HombreDTO(String edad, float estatura, String fotoPerfil, int meGusta, boolean disponibilidad, String lugar,
			boolean sexo) {
		super(edad, estatura, fotoPerfil, meGusta, disponibilidad, lugar, sexo);
		// TODO Auto-generated constructor stub
	}

	public HombreDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
			String codigoVerificacion, String edad, float estatura, String fotoPerfil, int meGusta,
			boolean disponibilidad, String lugar, boolean sexo) {
		super(nombre, alias, cedula, correo, contrasenya, codigoVerificacion, edad, estatura, fotoPerfil, meGusta,
				disponibilidad, lugar, sexo);
		// TODO Auto-generated constructor stub
	}

	public HombreDTO(String nombre, String alias, long cedula, String correo, String contrasenya,
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

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Hombre " + ", salario=" + salario + "]";
	}

}