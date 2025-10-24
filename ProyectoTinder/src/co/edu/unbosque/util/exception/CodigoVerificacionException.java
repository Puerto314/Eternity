package co.edu.unbosque.util.exception;

public class CodigoVerificacionException extends Exception {

	public CodigoVerificacionException() {
		super("Ingrese un código válido (6 dígitos)");
	}

}
