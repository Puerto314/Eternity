package co.edu.unbosque.util.exception;

public class AliasException extends Exception {

	public AliasException() {
		super("El nombre de usuario debe ser único y tener entre 5 y 12 caracteres (mínimo 3 letras y sin caracteres)");
	}

}
