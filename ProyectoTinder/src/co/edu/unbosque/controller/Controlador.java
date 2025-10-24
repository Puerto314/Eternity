package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
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

public class Controlador implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;
	private String rutaImagenProducto = "";

	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();

	}

	public void runGUI() {
		vf.getVentanaInicio().setVisible(true);
		vf.getVentanaPrincipal().setVisible(false);
		vf.getVentanaRegistro().setVisible(false);
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
		case "boton_registro_crear": {
			String usuario, contrasenya, nombre, correo, estatura, edad;

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

			try {
				estatura = vf.getVentanaRegistro().getCampoEstatura().getText();
				LanzadorException.verificarEstaturaValida(estatura);
			} catch (EstaturaException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR ESTATURA", JOptionPane.ERROR_MESSAGE);
				break;
			}

			edad = vf.getVentanaRegistro().getCampoEdad().getText();

			String sexoSeleccionado = (String) vf.getVentanaRegistro().getListaSexos().getSelectedItem();
			boolean esHombre = sexoSeleccionado.equals("Hombre");

			if (esHombre) {
				HombreDTO nuevoHombre = new HombreDTO();
				nuevoHombre.setAlias(usuario);
				nuevoHombre.setContrasenya(contrasenya);
				nuevoHombre.setNombre(nombre);
				nuevoHombre.setCorreo(correo);
				nuevoHombre.setEdad(edad);
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
				nuevaMujer.setEdad(edad);
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
				String contrasenyaIngresada = vf.getVentanaInicio().getCampoContrasenya().getText();
				boolean encontrado = false;

				for (HombreDTO u : mf.getHomDAO().leerTodos()) {
					if (u.getAlias().equals(usuarioIngresado) && u.getContrasenya().equals(contrasenyaIngresada)) {
						encontrado = true;
						JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso como HOMBRE");
						vf.getVentanaInicio().dispose();
						vf.getVentanaPrincipal().setVisible(true);
						break;
					}
				}

				if (!encontrado) {
					for (MujerDTO u : mf.getMujDAO().leerTodos()) {
						if (u.getAlias().equals(usuarioIngresado) && u.getContrasenya().equals(contrasenyaIngresada)) {
							encontrado = true;
							JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso como MUJER");
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
