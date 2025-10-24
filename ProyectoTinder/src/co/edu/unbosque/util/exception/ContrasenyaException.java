package co.edu.unbosque.util.exception;

public class ContrasenyaException extends Exception {

	public ContrasenyaException() {
		super("La contraseña debe tener entre 4 y 8 dígitos. Debe tener minúsculas, mayúsculas y números");
	}

}
