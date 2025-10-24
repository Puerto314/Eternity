package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

public class HombreDAO implements DAO<HombreDTO> {

	private List<HombreDTO> listaHombreDTO = new ArrayList<>();
	private ArrayList<Hombre> listaHombre;
	private final String FILE_NAME = "Hombre.csv";
	private final String SERIAL_FILE_NAME = "Hombres.bin";

	public HombreDAO() {
		listaHombre = new ArrayList<>();
		cargarDesdeArchivoSerializado();
	}

	@Override
	public void crear(HombreDTO dto) {
		Hombre nuevoDato = DataMapper.convertirHombreDTOAHombre(dto);
		listaHombre.add(nuevoDato);
		escribirDesdeArchivoSerializado();
	}

	private String contenido;
	private int i;

	@Override
	public String mostrarDatos() {
		contenido = "";
		i = 1;
		listaHombre.forEach((Hombre) -> {
			contenido += "| " + i + " |" + Hombre.toString();
			i++;
		});

		return contenido;
	}

	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaHombre.size()) {
			return false;
		} else {
			listaHombre.remove(indice);
			escribirDesdeArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, HombreDTO dto) {
		if (indice < 0 || indice >= listaHombre.size()) {
			return false;
		} else {
			Hombre datoActualizado = DataMapper.convertirHombreDTOAHombre(dto);
			listaHombre.set(indice, datoActualizado);
			escribirDesdeArchivoSerializado();
			return true;
		}
	}

	@Override
	public int contar() {
		return listaHombre.size();
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
		for (Hombre Hombre : listaHombre) {

		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());

	}

	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaHombre = (ArrayList<Hombre>) contenido;
		} else {
			listaHombre = new ArrayList<>();
		}

	}

	@Override
	public void escribirDesdeArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, listaHombre);

	}

	@Override
	public void ponerPropiedades(Properties prop) {
		for (Hombre hombre : listaHombre) {
			hombre.setProp(prop);
		}
	}

	public String mostrarHombresMasLikes() {
		if (listaHombre.isEmpty()) {
			return "No hay hombres registrados.\n";
		}

		quickSort(listaHombre, 0, listaHombre.size() - 1);

		String cont = "";
		int limite = Math.min(10, listaHombre.size());
		for (int i = 0; i < limite; i++) {
			cont += listaHombre.get(i).toString() + "\n";
		}

		return cont;
	}

	public void quickSort(ArrayList<Hombre> lista, int menor, int mayor) {
		if (menor < mayor) {
			int pivote = particionar(lista, menor, mayor);
			quickSort(lista, menor, pivote - 1);
			quickSort(lista, pivote + 1, mayor);
		}
	}

	public int particionar(ArrayList<Hombre> lista, int menor, int mayor) {
		Hombre pivote = lista.get(mayor);
		int i = (menor - 1);
		for (int j = menor; j < mayor; j++) {
			if (lista.get(j).getMeGusta() > pivote.getMeGusta()) {
				i++;
				Hombre temp = lista.get(i);
				lista.set(i, lista.get(j));
				lista.set(j, temp);
			}
		}
		Hombre temp = lista.get(i + 1);
		lista.set(i + 1, lista.get(mayor));
		lista.set(mayor, temp);
		return i + 1;
	}

	@Override
	public List<HombreDTO> leerTodos() {
		List<HombreDTO> listaDTO = new ArrayList<>();
		for (Hombre h : listaHombre) {
			listaDTO.add(DataMapper.convertirHombreAHombreDTO(h));
		}
		return listaDTO;
	}

	public ArrayList<Hombre> getListaHombre() {
		return listaHombre;
	}

	public void setListaHombre(ArrayList<Hombre> listaHombre) {
		this.listaHombre = listaHombre;
	}

	public List<HombreDTO> getListaHombreDTO() {
		return listaHombreDTO;
	}

	public void setListaHombreDTO(List<HombreDTO> listaHombreDTO) {
		this.listaHombreDTO = listaHombreDTO;
	}

}