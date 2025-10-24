package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Properties;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;

public class AdministradorDAO implements DAO<AdministradorDTO> {

	private ArrayList<Administrador> listaAdministrador;
	private final String FILE_NAME = "Administrador.csv";
	private final String SERIAL_FILE_NAME = "Adminisstrador.bin";

	public AdministradorDAO() {
		listaAdministrador = new ArrayList<>();
		cargarDesdeArchivoSerializado();
	}

	@Override
	public void crear(AdministradorDTO dto) {
		Administrador nuevoDato = DataMapper.convertirAdministradorDTOAAdministrador(dto);
		listaAdministrador.add(nuevoDato);
		escribirDesdeArchivoSerializado();
	}

	private String contenido;
	private int i;

	@Override
	public String mostrarDatos() {
		contenido = "";
		i = 1;
		listaAdministrador.forEach((Administrador) -> {
			contenido += "| " + i + " |" + Administrador.toString();
			i++;
		});

		return contenido;
	}

	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaAdministrador.size()) {
			return false;
		} else {
			listaAdministrador.remove(indice);
			escribirDesdeArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, AdministradorDTO dto) {
		if (indice < 0 || indice >= listaAdministrador.size()) {
			return false;
		} else {
			Administrador datoActualizado = DataMapper.convertirAdministradorDTOAAdministrador(dto);
			listaAdministrador.set(indice, datoActualizado);
			escribirDesdeArchivoSerializado();
			return true;
		}
	}

	@Override
	public int contar() {
		return listaAdministrador.size();
	}

	@Override
	public void leerDesdeArchivoTexto(String url) {
		String contenido = FileHandler.leerDesdeArchivoTexto(url);
		if (contenido == "" || contenido.isBlank()) {
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {

		}
	}

	@Override
	public void escribirDesdeArchivoTexto() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (Administrador Administrador : listaAdministrador) {

		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());

	}

	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaAdministrador = (ArrayList<Administrador>) contenido;
		} else {
			listaAdministrador = new ArrayList<>();
		}

	}

	@Override
	public void escribirDesdeArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, listaAdministrador);

	}

	@Override
	public void ponerPropiedades(Properties prop) {
		for (Administrador administrador : listaAdministrador) {
			administrador.setProp(prop);
		}
	}

	public ArrayList<Administrador> getListaAdministrador() {
		return listaAdministrador;
	}

	public void setListaAdministrador(ArrayList<Administrador> listaAdministrador) {
		this.listaAdministrador = listaAdministrador;
	}

	


}