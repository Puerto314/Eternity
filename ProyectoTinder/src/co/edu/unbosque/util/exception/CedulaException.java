package co.edu.unbosque.util.exception;

public class CedulaException extends Exception {

	public CedulaException() {
		super("Ingrese un número de identificación válido (10 números sin espacios)");
	}

}
