package co.edu.unbosque.model.persistence;

import java.util.List;
import java.util.Properties;

public interface DAO<A> {

	public void crear(A nuevoDato);

	public String mostrarDatos();

	public boolean eliminar(int indice);

	public boolean actualizar(int indice, A datoActualizado);

	public int contar();

	public void leerDesdeArchivoTexto(String url);

	public void escribirDesdeArchivoTexto();

	public void cargarDesdeArchivoSerializado();

	public void escribirDesdeArchivoSerializado();

	public void ponerPropiedades(Properties prop);

	public List<A> leerTodos();// CRUD

}
