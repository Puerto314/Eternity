import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.DataMapper;

public class AdministradorDAOTest {

	static AdministradorDAO aDAO;
	static int cuentaBefore;
	static int cuentaAfter;
	static ArrayList<Administrador> listaAntes;

	@BeforeClass
	public static void antesDeTodo() {
		aDAO = new AdministradorDAO();
		listaAntes = aDAO.getListaAdministrador();
		cuentaBefore = 0;
		cuentaAfter = 0;
		System.out.println("Empezando pruebas unitarias de AdministradorDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		cuentaBefore++;
		System.out.println("Iniciando prueba " + cuentaBefore);
	}

	@Test
	public void crear() {
		AdministradorDTO aDTO = new AdministradorDTO("1", "1", 1, "1", "1", "1", "1");
		aDAO.crear(aDTO);

		Administrador entity = listaAntes.getLast();
		boolean resultado = false;
		if (entity.getNombre().equals(aDTO.getNombre()) && entity.getAlias().equals(aDTO.getAlias())
				&& entity.getCedula() == aDTO.getCedula() && entity.getCorreo().equals(aDTO.getCorreo())
				&& entity.getContrasenya().equals(aDTO.getContrasenya())
				&& entity.getCodigoVerificacion() == aDTO.getCodigoVerificacion()
				&& entity.getCompanyia().equals(aDTO.getCompanyia())) {
			resultado = true;

		}
		assertEquals(true, resultado);
		aDAO.eliminar(listaAntes.lastIndexOf(entity));
	}

	@Test
	public void crearMal() {
		AdministradorDTO aDTO = new AdministradorDTO("1", "1", 1, "1", "1", "1", "1");
		aDAO.crear(aDTO);

		Administrador entity = listaAntes.getLast();
		boolean resultado = true;
		if (!"0".equals(aDTO.getNombre()) || !entity.getAlias().equals(aDTO.getAlias())
				|| entity.getCedula() != aDTO.getCedula() || !entity.getCorreo().equals(aDTO.getCorreo())
				|| !entity.getContrasenya().equals(aDTO.getContrasenya())
				|| entity.getCodigoVerificacion() != aDTO.getCodigoVerificacion()
				|| !entity.getCompanyia().equals(aDTO.getCompanyia())) {
			resultado = false;

		}

		assertEquals(false, resultado);
		aDAO.eliminar(listaAntes.lastIndexOf(entity));
	}

	@Test
	public void mostrar() {
		listaAntes.clear();
		AdministradorDTO aDTO = new AdministradorDTO("1", "1", 1, "1", "1", "1", "1");
		Administrador a = DataMapper.convertirAdministradorDTOAAdministrador(aDTO);
		listaAntes.add(a);
		aDAO.mostrarDatos();

	}

	@After
	public void despuesDeCadaPrueba() {
		cuentaAfter++;
		System.out.println("Finalizando prueba: " + cuentaAfter);
	}

	@AfterClass
	public static void despuesDeTodo() {
		aDAO.setListaAdministrador(listaAntes);
		System.out.println("Pruebas unitarias de administradorDAO terminadas.");
	}

}