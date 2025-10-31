package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Period;
import java.util.Properties;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.util.exception.AliasException;
import co.edu.unbosque.util.exception.ContrasenyaException;
import co.edu.unbosque.util.exception.CorreoException;
import co.edu.unbosque.util.exception.EstaturaException;
import co.edu.unbosque.util.exception.LanzadorException;
import co.edu.unbosque.util.exception.NombreException;
import co.edu.unbosque.view.ViewFacade;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Controlador implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;
	private String rutaImagenProducto = "";
	private LocalDate fechaNacimientoUsuario = null;

	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();

	}

	public void runGUI() {
		vf.getVentanaInicio().setVisible(true);
		vf.getVentanaPrincipal().setVisible(false);
		vf.getVentanaRegistro().setVisible(false);
		vf.getVentanaEdad().setVisible(false);
		asignarListeners();
	}

	public void asignarListeners() {
		vf.getVentanaPrincipal().getBotonPerfil().addActionListener(this);
		vf.getVentanaPrincipal().getBotonPerfil().setActionCommand("PERFIL");

		vf.getVentanaInicio().getBtnCrearCuenta().addActionListener(this);
		vf.getVentanaInicio().getBtnCrearCuenta().setActionCommand("boton_crear_cuenta");

		vf.getVentanaRegistro().getBtnVolver().addActionListener(this);
		vf.getVentanaRegistro().getBtnVolver().setActionCommand("boton_registro_volver");

		vf.getVentanaRegistro().getBtnCrear().addActionListener(this);
		vf.getVentanaRegistro().getBtnCrear().setActionCommand("boton_registro_crear");

		vf.getVentanaInicio().getBtnIniciarSesion().addActionListener(this);
		vf.getVentanaInicio().getBtnIniciarSesion().setActionCommand("boton_iniciar_sesion");

		vf.getVentanaPrincipal().getBotonCerrarSesion().addActionListener(this);
		vf.getVentanaPrincipal().getBotonCerrarSesion().setActionCommand("boton_cerrar_sesion");

		vf.getVentanaRegistro().getBotonSeleccionarImagen().addActionListener(this);
		vf.getVentanaRegistro().getBotonSeleccionarImagen().setActionCommand("boton_seleccionar_imagen");

		vf.getVentanaRegistro().getBotonEdad().addActionListener(this);
		vf.getVentanaRegistro().getBotonEdad().setActionCommand("boton_edad");

		vf.getVentanaEdad().getBtnIngresar().addActionListener(this);
		vf.getVentanaEdad().getBtnIngresar().setActionCommand("boton_ingresar_edad");

	}

	/*
	 * public void runTest() { prop =
	 * FileHandler.cargarArchivoPropiedades("spa.properties");
	 * cargarPropiedades(prop);
	 * 
	 * System.out.println(mf.getMujDAO().mostrarMujeresMasLikes()); }
	 * 
	 * public void run() { prop =
	 * FileHandler.cargarArchivoPropiedades("eng.properties");
	 * cargarPropiedades(prop);
	 * 
	 * asignarListeners(); }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();

		switch (alias) {

		/*
		 * case "IDIOMA": { String idiomaSeleccionado = ""; // = (String)
		 * vf.getWin().getCmbIdioma().getSelectedItem() switch (idiomaSeleccionado) {
		 * case "Español": { prop =
		 * FileHandler.cargarArchivoPropiedades("spa.properties"); break; } case
		 * "English": { prop = FileHandler.cargarArchivoPropiedades("eng.properties");
		 * 
		 * break; } case "Português": { prop =
		 * FileHandler.cargarArchivoPropiedades("por.properties"); break; } case
		 * "русский язык": { prop =
		 * FileHandler.cargarArchivoPropiedades("rus.properties"); break; } case "普通话":
		 * { prop = FileHandler.cargarArchivoPropiedades("ch.properties"); break; } case
		 * "עברית": { prop = FileHandler.cargarArchivoPropiedades("heb.properties");
		 * break; }
		 * 
		 * // CIERRE DE LOS CASE } cargarPropiedades(prop); // vf.ventana.repaint() //
		 * vf.ventana.revalidate break;
		 */

		case "boton_edad": {
			vf.getVentanaEdad().setVisible(true);
			break;
		}
		case "boton_crear_cuenta": {
			vf.getVentanaInicio().dispose();
			vf.getVentanaRegistro().setVisible(true);
			break;
		}
		case "boton_registro_volver": {
			vf.getVentanaRegistro().dispose();
			vf.getVentanaInicio().setVisible(true);
			break;
		}
		case "boton_ingresar_edad": {
			int dia = (int) vf.getVentanaEdad().getComboDia().getSelectedItem();
			String mesNombre = (String) vf.getVentanaEdad().getComboMes().getSelectedItem();
			int anio = (int) vf.getVentanaEdad().getComboAnio().getSelectedItem();

			int mes = switch (mesNombre) {
			case "Enero" -> 1;
			case "Febrero" -> 2;
			case "Marzo" -> 3;
			case "Abril" -> 4;
			case "Mayo" -> 5;
			case "Junio" -> 6;
			case "Julio" -> 7;
			case "Agosto" -> 8;
			case "Septiembre" -> 9;
			case "Octubre" -> 10;
			case "Noviembre" -> 11;
			case "Diciembre" -> 12;
			default -> 0;
			};

			LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
			LocalDate hoy = LocalDate.now();
			Period edad = Period.between(fechaNacimiento, hoy);

			if (edad.getYears() >= 18) {
				JOptionPane.showMessageDialog(null, "Edad guardada correctamente: " + edad.getYears() + " años");
				fechaNacimientoUsuario = fechaNacimiento;
				vf.getVentanaEdad().dispose();
				vf.getVentanaRegistro().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Acceso denegado (debe ser mayor de edad)");
			}
			break;
		}

		case "boton_registro_crear": {

			if (fechaNacimientoUsuario == null) {
				JOptionPane.showMessageDialog(null,
						"Debe seleccionar su fecha de nacimiento antes de crear una cuenta.",
						"ERROR FECHA DE NACIMIENTO", JOptionPane.ERROR_MESSAGE);
				break;
			}

			Period edad = Period.between(fechaNacimientoUsuario, LocalDate.now());
			if (edad.getYears() < 18) {
				JOptionPane.showMessageDialog(null, "Debe ser mayor de edad para registrarse.", "ERROR EDAD",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			String usuario, contrasenya, nombre, correo, estatura;

			try {
				usuario = vf.getVentanaRegistro().getCampoAlias().getText();
				LanzadorException.verificarAliasValido(usuario);
			} catch (AliasException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR ALIAS", JOptionPane.ERROR_MESSAGE);
				break;
			}

			try {
				contrasenya = vf.getVentanaRegistro().getCampoContrasenya().getText();
				LanzadorException.verificarContrasenyaValida(contrasenya);
			} catch (ContrasenyaException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR CONTRASEÑA", JOptionPane.ERROR_MESSAGE);
				break;
			}

			try {
				nombre = vf.getVentanaRegistro().getCampoNombre().getText();
				LanzadorException.verificarNombreValido(nombre);
			} catch (NombreException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR NOMBRE", JOptionPane.ERROR_MESSAGE);
				break;
			}

			try {
				correo = vf.getVentanaRegistro().getCampoCorreo().getText();
				LanzadorException.verificarCorreoValido(correo);
			} catch (CorreoException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR CORREO", JOptionPane.ERROR_MESSAGE);
				break;
			}

			String sexoSeleccionado = (String) vf.getVentanaRegistro().getListaSexos().getSelectedItem();
			boolean esHombre = sexoSeleccionado.equals("Hombre");

			estatura = vf.getVentanaRegistro().getCampoEstatura().getText();

			if (esHombre) {
				try {
					LanzadorException.verificarEstaturaValida(estatura);
				} catch (EstaturaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR ESTATURA", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} else {
				if (estatura.isEmpty()) {
					estatura = "0";
				} else {
					try {
						LanzadorException.verificarEstaturaValida(estatura);
					} catch (EstaturaException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR ESTATURA",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
				}
			}

			// JAKARTA MAIL
			try {
				String codigoVerificacion = String.valueOf(new Random().nextInt(900000) + 100000);

				final String remitente = "tindtec@gmail.com";
				final String clave = "jvzq ylax ivwx hwyr";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.port", "587");

				if (remitente.endsWith("@gmail.com")) {
					props.put("mail.smtp.host", "smtp.gmail.com");
				} else if (remitente.endsWith("@hotmail.com") || remitente.endsWith("@outlook.com")
						|| remitente.endsWith("@live.com")) {
					props.put("mail.smtp.host", "smtp.office365.com");
				} else if (remitente.endsWith("@yahoo.com") || remitente.endsWith("@yahoo.es")) {
					props.put("mail.smtp.host", "smtp.mail.yahoo.com");
				} else if (remitente.endsWith("@unbosque.edu.co") || remitente.endsWith("@outlook.es")) {
					props.put("mail.smtp.host", "smtp.office365.com");
				} else {
					JOptionPane.showMessageDialog(null, "Dominio de correo no soportado.");
					break;
				}

				Session session = Session.getInstance(props, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(remitente, clave);
					}
				});

				JOptionPane.showMessageDialog(null, "Enviando correo de verificación...", "Correo",
						JOptionPane.INFORMATION_MESSAGE);

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(remitente));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
				message.setSubject("Código de verificación");
				message.setText("Tu código de verificación es: " + codigoVerificacion);
				Transport.send(message);

				JOptionPane.showMessageDialog(null, "Se ha enviado un código de verificación a su correo.");

				boolean verificado = false;

				while (!verificado) {
					String codigoIngresado = JOptionPane.showInputDialog(null,
							"Ingrese el código de verificación enviado a su correo:", "Verificación de correo",
							JOptionPane.PLAIN_MESSAGE);

					if (codigoIngresado == null) {
						JOptionPane.showMessageDialog(null, "Verificación cancelada.");
						break;
					}

					if (codigoIngresado.trim().equals(codigoVerificacion)) {
						JOptionPane.showMessageDialog(null, "Verificación exitosa.");
						verificado = true;
					} else {
						JOptionPane.showMessageDialog(null, "Código incorrecto. Se enviará uno nuevo.");

						codigoVerificacion = String.valueOf(new Random().nextInt(900000) + 100000);
						message.setText("Tu nuevo código de verificación es: " + codigoVerificacion);
						Transport.send(message);
					}
				}

				if (!verificado)
					break;

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al enviar o verificar el correo.\n" + ex.getMessage());
				break;
			}
			// TERMINA EL JAKARTA MAIL

			if (esHombre) {
				HombreDTO nuevoHombre = new HombreDTO();
				nuevoHombre.setAlias(usuario);
				nuevoHombre.setContrasenya(contrasenya);
				nuevoHombre.setNombre(nombre);
				nuevoHombre.setCorreo(correo);
				nuevoHombre.setEstatura(Float.parseFloat(estatura));
				nuevoHombre.setEsHombre(true);

				mf.getHomDAO().crear(nuevoHombre);
				JOptionPane.showMessageDialog(null, "Cuenta creada con éxito como hombre");

			} else {
				MujerDTO nuevaMujer = new MujerDTO();
				nuevaMujer.setAlias(usuario);
				nuevaMujer.setContrasenya(contrasenya);
				nuevaMujer.setNombre(nombre);
				nuevaMujer.setCorreo(correo);
				nuevaMujer.setEstatura(Float.parseFloat(estatura));
				nuevaMujer.setEsHombre(false);

				mf.getMujDAO().crear(nuevaMujer);
				JOptionPane.showMessageDialog(null, "Cuenta creada con éxito como mujer");
			}

			vf.getVentanaRegistro().dispose();
			vf.getVentanaInicio().setVisible(true);
			break;
		}

		case "boton_iniciar_sesion": {
			try {
				String usuarioIngresado = vf.getVentanaInicio().getCampoUsuario().getText();
				char[] contrasenya = vf.getVentanaInicio().getCampoContrasenya().getPassword();
				String contrasenyaIngresada = new String(contrasenya);
				boolean encontrado = false;

				for (HombreDTO u : mf.getHomDAO().leerTodos()) {
					if (u.getAlias().equals(usuarioIngresado) && u.getContrasenya().equals(contrasenyaIngresada)) {
						encontrado = true;
						JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
						vf.getVentanaInicio().dispose();
						vf.getVentanaPrincipal().setVisible(true);
						break;
					}
				}

				if (!encontrado) {
					for (MujerDTO u : mf.getMujDAO().leerTodos()) {
						if (u.getAlias().equals(usuarioIngresado) && u.getContrasenya().equals(contrasenyaIngresada)) {
							encontrado = true;
							JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
							vf.getVentanaInicio().dispose();
							vf.getVentanaPrincipal().setVisible(true);
							break;
						}
					}
				}

				if (!encontrado) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error al iniciar sesión", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			break;
		}

		case "boton_cerrar_sesion": {
			vf.getVentanaPrincipal().dispose();
			vf.getVentanaInicio().setVisible(true);
			break;
		}

		case "boton_seleccionar_imagen": {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Directorio actual del proyecto
			int result = fileChooser.showOpenDialog(vf.getVentanaRegistro());
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String fileName = selectedFile.getName();

				// Ruta relativa para guardar la imagen en la carpeta 'view'
				File destinationFolder = new File("MercadoLibre/MercadoLibre/MercadoLibre/src/co/edu/unbosque/view/");
				if (!destinationFolder.exists()) {
					destinationFolder.mkdirs(); // Crear la carpeta si no existe
				}
				File destinationFile = new File(destinationFolder, fileName);

				try {
					Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR DIRECCION", JOptionPane.ERROR_MESSAGE);
				}
				rutaImagenProducto = "co/edu/unbosque/view/" + fileName; // Guardar la ruta relativa para el modelo
				vf.getVentanaRegistro().getLabelImagenSeleccionada().setText("Imagen seleccionada: " + fileName);
				JOptionPane.showMessageDialog(vf.getVentanaRegistro(), "Imagen cargada con éxito: " + fileName);

			}
			break;
		}

		} // CIERRA EL SWITCH

		/*
		 * default: throw new IllegalArgumentException("Unexpected value: " + alias);
		 */
	} // CIERRA EL ACTION PERFORMED

	/*
	 * switch (e.getActionCommand()) { case "PERFIL": {
	 * JOptionPane.showMessageDialog(null, "Hola", "Perfil",
	 * JOptionPane.INFORMATION_MESSAGE, null);
	 * 
	 * break; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * public void cargarPropiedades(Properties prop) { mf.cargarPropiedades(prop);
	 * vf.cargarPropiedades(prop); }
	 */
}
