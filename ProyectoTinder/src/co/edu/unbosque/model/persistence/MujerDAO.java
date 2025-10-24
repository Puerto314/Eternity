package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class MujerDAO implements DAO<MujerDTO> {

	private List<MujerDTO> listaMujerDTO = new ArrayList<>();
	private ArrayList<Mujer> listaMujer;
	private final String FILE_NAME = "Mujer.csv";
	private final String SERIAL_FILE_NAME = "Mujer.bin";

	public MujerDAO() {
		listaMujer = new ArrayList<>();
		cargarDesdeArchivoSerializado();
	}

	@Override
	public void crear(MujerDTO dto) {
		Mujer nuevoDato = DataMapper.convertirMujerDTOAMujer(dto);
		listaMujer.add(nuevoDato);
		escribirDesdeArchivoSerializado();
	}

	private String contenido;
	private int i;

	@Override
	public String mostrarDatos() {
		contenido = "";
		i = 1;
		listaMujer.forEach((Mujer) -> {
			contenido += "| " + i + " |" + Mujer.toString();
			i++;
		});

		return contenido;
	}

	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaMujer.size()) {
			return false;
		} else {
			listaMujer.remove(indice);
			escribirDesdeArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, MujerDTO dto) {
		if (indice < 0 || indice >= listaMujer.size()) {
			return false;
		} else {
			Mujer datoActualizado = DataMapper.convertirMujerDTOAMujer(dto);
			listaMujer.set(indice, datoActualizado);
			escribirDesdeArchivoSerializado();
			return true;
		}
	}

	@Override
	public int contar() {
		return listaMujer.size();
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
		for (Mujer Mujer : listaMujer) {

		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());

	}

	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaMujer = (ArrayList<Mujer>) contenido;
		} else {
			listaMujer = new ArrayList<>();
		}

	}

	@Override
	public void escribirDesdeArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, listaMujer);

	}

	@Override
	public void ponerPropiedades(Properties prop) {
		for (Mujer mujer : listaMujer) {
			mujer.setProp(prop);
		}
	}

	public String mostrarMujeresMasLikes() {
		if (listaMujer.isEmpty()) {
			return "No hay hombres registrados.\n";
		}

		quickSort(listaMujer, 0, listaMujer.size() - 1);

		String cont = "";
		int limite = Math.min(10, listaMujer.size());
		for (int i = 0; i < limite; i++) {
			cont += listaMujer.get(i).toString() + "\n";
		}

		return cont;
	}

	public void quickSort(ArrayList<Mujer> lista, int menor, int mayor) {
		if (menor < mayor) {
			int pivote = particionar(lista, menor, mayor);
			quickSort(lista, menor, pivote - 1);
			quickSort(lista, pivote + 1, mayor);
		}
	}

	public int particionar(ArrayList<Mujer> lista, int menor, int mayor) {
		Mujer pivote = lista.get(mayor);
		int i = (menor - 1);
		for (int j = menor; j < mayor; j++) {
			if (lista.get(j).getMeGusta() > pivote.getMeGusta()) {
				i++;
				Mujer temp = lista.get(i);
				lista.set(i, lista.get(j));
				lista.set(j, temp);
			}
		}
		Mujer temp = lista.get(i + 1);
		lista.set(i + 1, lista.get(mayor));
		lista.set(mayor, temp);
		return i + 1;
	}

	public ArrayList<Mujer> getListaMujer() {
		return listaMujer;
	}

	public void setListaMujer(ArrayList<Mujer> listaMujer) {
		this.listaMujer = listaMujer;
	}

	@Override
	public List<MujerDTO> leerTodos() {
		List<MujerDTO> listaDTO = new ArrayList<>();
		for (Mujer h : listaMujer) {
			listaDTO.add(DataMapper.convertirMujerAMujerDTO(h));
		}
		return listaDTO;
	}

	public List<MujerDTO> getListaMujerDTO() {
		return listaMujerDTO;
	}

	public void setListaMujerDTO(List<MujerDTO> listaMujerDTO) {
		this.listaMujerDTO = listaMujerDTO;
	}

}
