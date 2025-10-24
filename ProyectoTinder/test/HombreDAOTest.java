import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.persistence.HombreDAO;


public class HombreDAOTest {

	static HombreDAO hDAO;
	static int cuentaBefore;	
	static int cuentaAfter;
	static ArrayList<Hombre> listaAntes;

	
	@BeforeClass
	public static void antesDeTodo() {
		hDAO = new HombreDAO();
		listaAntes = hDAO.getListaHombre();
		cuentaBefore = 0;
		cuentaAfter = 0;
		System.out.println("Empezando pruebas unitarias de HombreDAO");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		cuentaBefore++;
		System.out.println("Iniciando prueba " + cuentaBefore);
	}
	
	@Test
	public void crear() {
		HombreDTO hDTO = new HombreDTO("1", "1", 1, "1", "1", "1", "1", 1, "1", 1, true, "1", true, 1);
		hDAO.crear(hDTO);
		
		Hombre entity = listaAntes.getLast();
		boolean resultado = false;
		if(entity.getNombre().equals(hDTO.getNombre()) && entity.getAlias().equals(hDTO.getAlias()) && entity.getCedula() == hDTO.getCedula() &&
				entity.getCorreo().equals(hDTO.getCorreo()) && entity.getContrasenya().equals(hDTO.getContrasenya()) && entity.getCodigoVerificacion() == hDTO.getCodigoVerificacion() && 
				entity.getEdad().equals(hDTO.getEdad()) && entity.getEstatura() == hDTO.getEstatura() &&
				entity.getFotoPerfil().equals(hDTO.getFotoPerfil()) && entity.getMeGusta() == hDTO.getMeGusta() && entity.isEstaDisponible() == hDTO.isEstaDisponible() && entity.getLugar().equals(hDTO.getLugar()) &&
				entity.isEsHombre() == hDTO.isEsHombre() && entity.getSalario() == hDTO.getSalario()) {
			resultado = true;
			
		}
		assertEquals(true, resultado);
		hDAO.eliminar(listaAntes.lastIndexOf(entity));
	}
	@Test
	public void crearMal() {
		HombreDTO hDTO = new HombreDTO("1", "1", 1, "1", "1", "1", "1", 1, "1", 1, true, "1", true, 1);
		hDAO.crear(hDTO);
		
		Hombre entity = listaAntes.getLast();
		boolean resultado = true;
		if(!"0".equals(hDTO.getNombre()) || !entity.getAlias().equals(hDTO.getAlias()) || entity.getCedula() != hDTO.getCedula() ||
				!entity.getCorreo().equals(hDTO.getCorreo()) || !entity.getContrasenya().equals(hDTO.getContrasenya()) || entity.getCodigoVerificacion() != hDTO.getCodigoVerificacion() || 
				!entity.getEdad().equals(hDTO.getEdad()) || entity.getEstatura() != hDTO.getEstatura() ||
				!entity.getFotoPerfil().equals(hDTO.getFotoPerfil()) || entity.getMeGusta() != hDTO.getMeGusta() || entity.isEstaDisponible() != hDTO.isEstaDisponible() || !entity.getLugar().equals(hDTO.getLugar()) ||
				entity.isEsHombre() != hDTO.isEsHombre() || entity.getSalario() != hDTO.getSalario()) {
			resultado = false;
			
		}
		
		assertEquals(false, resultado);
		hDAO.eliminar(listaAntes.lastIndexOf(entity));
	}
	
	
	
	@After
	public void despuesDeCadaPrueba() {
		cuentaAfter++;
		System.out.println("Finalizando prueba: "+ cuentaAfter);
	}
	@AfterClass
	public static void despuesDeTodo() {
		hDAO.setListaHombre(listaAntes);
		System.out.println("Pruebas unitarias de HombreDAO terminadas.");
	}
	
}