import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.MujerDAO;


public class MujerDAOTest {

	static MujerDAO mDAO;
	static int cuentaBefore;	
	static int cuentaAfter;
	static ArrayList<Mujer> listaAntes;

	
	@BeforeClass
	public static void antesDeTodo() {
		mDAO = new MujerDAO();
		listaAntes = mDAO.getListaMujer();
		cuentaBefore = 0;
		cuentaAfter = 0;
		System.out.println("Empezando pruebas unitarias de MujerDAO");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		cuentaBefore++;
		System.out.println("Iniciando prueba " + cuentaBefore);
	}
	
	@Test
	public void crear() {
		MujerDTO mDTO = new MujerDTO("1", "1", 1, "1", "1", "1", "1", 1, "1", 1, true, "1", true, true);
		mDAO.crear(mDTO);
		
		Mujer entity = listaAntes.getLast();
		boolean resultado = false;
		if(entity.getNombre().equals(mDTO.getNombre()) && entity.getAlias().equals(mDTO.getAlias()) && entity.getCedula() == mDTO.getCedula() &&
				entity.getCorreo().equals(mDTO.getCorreo()) && entity.getContrasenya().equals(mDTO.getContrasenya()) && entity.getCodigoVerificacion() == mDTO.getCodigoVerificacion() && 
				entity.getEdad().equals(mDTO.getEdad()) && entity.getEstatura() == mDTO.getEstatura() &&
				entity.getFotoPerfil().equals(mDTO.getFotoPerfil()) && entity.getMeGusta() == mDTO.getMeGusta() && entity.isEstaDisponible() == mDTO.isEstaDisponible() && entity.getLugar().equals(mDTO.getLugar()) &&
				entity.isEsHombre() == mDTO.isEsHombre() && entity.isEstaDivorciada() == mDTO.isEstaDivorciada()) {
			resultado = true;
			
		}
		assertEquals(true, resultado);
		mDAO.eliminar(listaAntes.lastIndexOf(entity));
	}
	@Test
	public void crearMal() {
		MujerDTO mDTO = new MujerDTO("1", "1", 1, "1", "1", "1", "1", 1, "1", 1, true, "1", true, true);
		mDAO.crear(mDTO);
		
		Mujer entity = listaAntes.getLast();
		boolean resultado = true;
		if(!"0".equals(mDTO.getNombre()) || !entity.getAlias().equals(mDTO.getAlias()) || entity.getCedula() != mDTO.getCedula() ||
				!entity.getCorreo().equals(mDTO.getCorreo()) || !entity.getContrasenya().equals(mDTO.getContrasenya()) || entity.getCodigoVerificacion() != mDTO.getCodigoVerificacion() || 
				!entity.getEdad().equals(mDTO.getEdad()) || entity.getEstatura() != mDTO.getEstatura() ||
				!entity.getFotoPerfil().equals(mDTO.getFotoPerfil()) || entity.getMeGusta() != mDTO.getMeGusta() || entity.isEstaDisponible() != mDTO.isEstaDisponible() || !entity.getLugar().equals(mDTO.getLugar()) ||
				entity.isEsHombre() != mDTO.isEsHombre() || entity.isEstaDivorciada() != mDTO.isEstaDivorciada()) {
			resultado = false;
			
		}
		
		assertEquals(false, resultado);
		mDAO.eliminar(listaAntes.lastIndexOf(entity));
	}
	
	
	
	@After
	public void despuesDeCadaPrueba() {
		cuentaAfter++;
		System.out.println("Finalizando prueba: "+ cuentaAfter);
	}
	@AfterClass
	public static void despuesDeTodo() {
		mDAO.setListaMujer(listaAntes);
		System.out.println("Pruebas unitarias de MujerDAO terminadas.");
	}
	
}