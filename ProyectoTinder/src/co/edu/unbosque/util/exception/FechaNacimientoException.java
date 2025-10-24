package co.edu.unbosque.util.exception;

public class FechaNacimientoException extends Exception {

	public FechaNacimientoException() {
		super("El ingreso solo es válido para mayores de 18");
	}

}
