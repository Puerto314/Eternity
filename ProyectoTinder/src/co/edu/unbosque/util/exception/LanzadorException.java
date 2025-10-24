package co.edu.unbosque.util.exception;

public class LanzadorException {

	public static void verificarAliasValido(String entrada) throws AliasException {
		if (entrada.length() < 5 || entrada.length() > 12) {
			throw new AliasException();
		}

		int contadorLetras = 0;

		for (char c : entrada.toCharArray()) {
			if (Character.isLetter(c)) {
				contadorLetras++;
			} else if (!Character.isDigit(c)) {
				throw new AliasException();
			}
		}

		if (contadorLetras < 3) {
			throw new AliasException();
		}
	}

	public static void verificarCedulaValida(String entrada) throws CedulaException {
		if (entrada.length() != 10) {
			throw new CedulaException();
		}

		if (entrada.charAt(0) == '0') {
			throw new CedulaException();
		}

		for (char c : entrada.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new CedulaException();
			}
		}

		if (entrada.contains("-")) {
			throw new CedulaException();
		}
	}

	// FALTA HACER QUE COINCIDA CON EL DEL CORREO
	public static void verificarCodigoValido(String entrada) throws CodigoVerificacionException {
		if (entrada.length() != 6) {
			throw new CodigoVerificacionException();
		}

		for (char c : entrada.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new CodigoVerificacionException();
			}
		}

		int numero = Integer.parseInt(entrada);

		if (numero <= 0) {
			throw new CodigoVerificacionException();
		}
	}

	public static void verificarCompanyaValida(String entrada) throws CompanyaException {
		if (entrada.length() < 2 || entrada.length() > 15) {
			throw new CompanyaException();
		}

		for (char c : entrada.toCharArray()) {
			if (!Character.isLetter(c)) {
				throw new CompanyaException();
			}
		}

	}

	public static void verificarContrasenyaValida(String entrada) throws ContrasenyaException {

		if (entrada.length() < 4 || entrada.length() > 8) {
			throw new ContrasenyaException();
		}

		boolean tieneMayuscula = false;
		boolean tieneMinuscula = false;
		boolean tieneNumero = false;

		for (char c : entrada.toCharArray()) {
			if (Character.isUpperCase(c)) {
				tieneMayuscula = true;
			} else if (Character.isLowerCase(c)) {
				tieneMinuscula = true;
			} else if (Character.isDigit(c)) {
				tieneNumero = true;
			}
		}

		if (!(tieneMayuscula && tieneMinuscula && tieneNumero)) {
			throw new ContrasenyaException();
		}

	}

	public static void verificarCorreoValido(String entrada) throws CorreoException {
		if (entrada == null || entrada.trim().isEmpty()) {
			throw new CorreoException();
		}

		entrada = entrada.trim();

		String patronDelCorreo = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(?:[A-Za-z]{2,})$";

		if (!entrada.matches(patronDelCorreo)) {
			throw new CorreoException();
		}

		if (!(entrada.endsWith("@unbosque.edu.co") || entrada.endsWith("@gmail.com")
				|| entrada.endsWith("@hotmail.com"))) {
			throw new CorreoException();
		}
	}

	public static void verificarEstaturaValida(String entrada) throws EstaturaException {
		if (entrada == null || entrada.isEmpty()) {
			throw new EstaturaException();
		}

		for (char c : entrada.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new EstaturaException();
			}
		}

		int estatura = Integer.parseInt(entrada);

		if (estatura < 50 || estatura > 220) {
			throw new EstaturaException();
		}
	}

	public static void verificarFechaNacimientoValida(String entrada) throws FechaNacimientoException {

	}

	public static void verificarNombreValido(String entrada) throws NombreException {
		entrada = entrada.trim();

		if (entrada.length() < 3 || entrada.length() > 13) {
			throw new NombreException();
		}
		for (char c : entrada.toCharArray()) {
			if (!Character.isLetter(c) && c != ' ') {
				throw new NombreException();
			}
		}

		if (entrada.isBlank()) {
			throw new NombreException();
		}
	}

	public static void verificarSalarioValido(String entrada) throws SalarioException {
		if (entrada == null || entrada.isEmpty()) {
			throw new SalarioException();
		}

		for (char c : entrada.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new SalarioException();
			}
		}

		long salario = Long.parseLong(entrada);

		if (salario < 0 || salario > 50000000) {
			throw new SalarioException();
		}
	}

}
