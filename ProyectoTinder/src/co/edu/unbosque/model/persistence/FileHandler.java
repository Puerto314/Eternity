package co.edu.unbosque.model.persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {

	// Texto
	public static File archivo;
	public static PrintWriter escritor;
	public static Scanner lector;
	// Serializado
	public static FileInputStream fis;
	public static ObjectInputStream ois;
	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
	public static Properties prop;

	public static void escribirEnArchivoTexto(String url, String contenido) {

		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al crear y escribibr el archivo");
			System.out.println(e.getMessage());
		}
	}

	public static String leerDesdeArchivoTexto(String url) {
		try {
			archivo = new File(url); // Apunta a la direccion
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lector = new Scanner(archivo);
			String contenido = "";
			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}
			lector.close();
			return contenido;
		} catch (IOException e) {
			System.out.println("Error al leer el archivo.");
			System.out.println(e.getMessage());
		}

		return null;
	}

	public static void escribirArchivoSerializado(String url, Object contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo serializado.");
			e.printStackTrace();

		}

	}

	public static Object leerArchivoSerializado(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
				return null;
			}

			if (archivo.length() == 0) {
				return null;
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object contenido = ois.readObject();
			ois.close();
			fis.close();
			return contenido;

		} catch (EOFException e) {
			return null;
		} catch (StreamCorruptedException e) {
			return null;
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error al leer archivo serializado: " + e.getMessage());
			return null;
		}
	}

	public static Properties cargarArchivoPropiedades(String url) {

		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			prop = new Properties();
			prop.load(new FileInputStream(archivo));
			return prop;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void escribirArchivoPropiedades(String url) {

	}
}
