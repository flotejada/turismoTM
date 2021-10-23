package turismoTM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Usuario {
	String nombre;
	float presupuesto;
	float tiempo;
	Set<Atraccion> atracciones;

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
