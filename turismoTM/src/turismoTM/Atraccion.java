package turismoTM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Atraccion extends Paquete {
	float costo;
	float tiempo;
	int cupo;
	String nombre;

	/**
	 * Construye una nueva atracción
	 * @param nombre El nombre de la atracción
	 * @param costo El costo al aceptar la atracción de forma individual
	 * @param tiempo Tiempo ocupado por la atracción
	 * @param cupo Cantidad de personas que pueden acceder a la atracción
	 */
	public Atraccion(String nombre, float costo, float tiempo, int cupo) {
		super();
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public float getCosto() {
		return this.costo;
	}

	@Override
	public float getTiempo() {
		return this.tiempo;
	}

	@Override
	public int getCupo() {
		return this.cupo;
	}

	public static List<Atraccion> lector(String archivo) throws FileNotFoundException {
		List<Atraccion> atracciones = new ArrayList<>();
		Scanner input = new Scanner(new File(archivo));
		input.nextLine();

		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] campos = line.split(",");
			Atraccion atraccion = new Atraccion(campos[0], Float.parseFloat(campos[1]), Float.parseFloat(campos[2]),
					Integer.parseInt(campos[3]));
			atracciones.add(atraccion);
		}
		input.close();
		return atracciones;
	}

	@Override
	public void fueAceptadoPor(Usuario usuario) {
		// TODO: Podemos almacenar la lista de usuarios que hay en alguna atracción.
		this.cupo -= 1;
	}
	
	@Override
	public List<Atraccion> getAtracciones() {
		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(this);
		return atracciones;
	}
}
