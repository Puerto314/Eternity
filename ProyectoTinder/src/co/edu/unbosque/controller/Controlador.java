package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.util.exception.AliasException;
import co.edu.unbosque.util.exception.LanzadorException;
import co.edu.unbosque.view.ViewFacade;

public class Controlador implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;

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
			String usuario, contrasenya, nombre, correo;
			boolean sexo;
			int edad, estatura;

			try {
				usuario = vf.getVentanaRegistro().getCampoAlias().getText();
				LanzadorException.verificarAliasValido(usuario);
			} catch (AliasException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR NOMBRE DE USUARIO",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			mf.getHomDAO().crear(new HombreDTO());

			JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
			vf.getVentanaRegistro().dispose();
			vf.getVentanaInicio().setVisible(true);
			break;
		}
		case "boton_iniciar_sesion": {
			vf.getVentanaInicio().dispose();
			vf.getVentanaPrincipal().setVisible(true);
			break;
		}
		case "boton_cerrar_sesion": {
			vf.getVentanaPrincipal().dispose();
			vf.getVentanaInicio().setVisible(true);
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
