package turismoTM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Promocion extends Paquete {
	List<Atraccion> atracciones = new ArrayList<>();
	String nombre;

	public Promocion(List<Atraccion> atracciones, String nombre) {
		super();
		this.atracciones = atracciones;
		this.nombre = nombre;
	}
	
	@Override
	public float getCosto(){
		float sum = 0;
		for (Atraccion atraccion: this.atracciones) {
			sum += atraccion.getCosto();
		}
		return sum;
	}
	
	@Override
	public int getCupo() {
		int min = this.atracciones.get(0).getCupo();
		for (Atraccion atraccion: this.atracciones) {
			if (atraccion.getCupo() < min) {
				min = atraccion.getCupo();
			}
		}
		return min;
	}
	
	@Override
	public float getTiempo(){
		float sum = 0;
		for (Atraccion atraccion: this.atracciones) {
			sum += atraccion.getTiempo();
		}
		return sum;
	}
	
	public static List<Promocion> lector(String archivo, List<Atraccion> todasAtracciones) throws FileNotFoundException {
		List<Promocion> promociones = new ArrayList<>();
		Scanner input = new Scanner(new File(archivo));
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] campos = line.split(",");
			
			String tipo = campos[0];
			
			String nombre = campos[1];
			
			String[] nombresAtracciones = campos[2].split("\\.");
			List<Atraccion> atracciones = new ArrayList<>();
			
			for (String nombreAtraccion: nombresAtracciones) {
				for (Atraccion atraccion: todasAtracciones) {
					if (atraccion.getNombre().equals(nombreAtraccion)) {
						atracciones.add(atraccion);
					}
				}
			}
			
			if (tipo.equals("axb")) {
				
				String[] nombresGratis = campos[2].split(".");
				List<Atraccion> gratis = new ArrayList<>();
				
				for (String nombreAtraccion: nombresGratis) {
					for (Atraccion atraccion: todasAtracciones) {
						if (atraccion.getNombre().equals(nombreAtraccion)) {
							gratis.add(atraccion);
						}
					}
				}
				
				Promocion promocionaxb = new PromocionAxB(atracciones, nombre, gratis);
				
				promociones.add(promocionaxb);
			}
			if (tipo.equals("absoluta")) {
				Promocion absoluta = new PromocionAbsoluta(atracciones, nombre, Float.parseFloat(campos[3]));
				promociones.add(absoluta);
			}
			if (tipo.equals("porcentual")) {
				Promocion porcentual = new PromocionPorcentaje(atracciones, nombre, Float.parseFloat(campos[3]));
				promociones.add(porcentual);
			}
		}
		input.close();
		return promociones;
	}

	@Override
	public void fueAceptadoPor(Usuario usuario) {
		for (Atraccion atraccion: this.atracciones) {
			atraccion.fueAceptadoPor(usuario);
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}
}
