package turismoTM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Usuario {
	private String nombre;
	private float presupuesto;
	private float tiempo;
	private Set<Atraccion> atracciones;

	/**
	 * Un usuario es una persona que puede acceptar paquetes en base a su presupuesto y tiempo
	 * @param nombre El nombre la persona. Este valor sirve como idenfificador
	 * @param presupuesto Cantidad de dinero que dispone el usuario
	 * @param tiempo Tiempo disponible para que el usuario pueda asistir a atracciones;
	 */
	public Usuario(String nombre, float presupuesto, float tiempo) {
		super();
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.atracciones = new HashSet<>();
	}

	public String getNombre() {
		return this.nombre;
	}
	public float getPresupuesto() {
		return this.presupuesto;
	}
	public float getTiempo() {
		return this.tiempo;
	}

	public void aceptaPaquete(Paquete paquete) {
		this.presupuesto -= paquete.getCosto();
		this.tiempo -= paquete.getTiempo();
		for (Atraccion atraccion: paquete.getAtracciones()) {
			this.atracciones.add(atraccion);
		}
		paquete.fueAceptadoPor(this);
	}

	public boolean puedeAceptar(Paquete paquete) {
		for (Atraccion atraccion: paquete.getAtracciones()) {
			if (this.atracciones.contains(atraccion)) {
				return false;
			}
		}
		if (this.presupuesto < paquete.getCosto()) return false;
		if (this.tiempo < paquete.getTiempo()) return false;
		if (paquete.getCupo() <= 0) return false;
		return true;
	}
	public static List<Usuario> lector(String archivo) throws FileNotFoundException {
		List<Usuario> usuarios = new ArrayList<>();
		Scanner input = new Scanner(new File(archivo));

		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] campos = line.split(",");
			Usuario usuario = new Usuario(campos[0], Float.parseFloat(campos[1]), Float.parseFloat(campos[2]));
			usuarios.add(usuario);
		}
		input.close();
		return usuarios;
	}
	
}
