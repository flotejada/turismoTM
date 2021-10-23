package turismoTM;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class sistema {
	public static void main(String[] args) {
		try {
			List<Atraccion> atracciones = Atraccion.lector("D:\\OneDrive - COPESJ\\Escritorio\\Metodos-Flor\\atracciones.csv");
			List<Usuario> usuarios = Usuario.lector("D:\\OneDrive - COPESJ\\Escritorio\\Metodos-Flor\\usuarios.csv");
			List<Promocion> promociones = Promocion.lector("D:\\OneDrive - COPESJ\\Escritorio\\Metodos-Flor\\promociones.csv",atracciones);
			

			int j;
			char eleccion;

			Scanner entrada = new Scanner(System.in);
			

			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getNombre());
				for (Promocion promocion: promociones) {
					if (usuario.puedeAceptar(promocion)) {
						System.out.println(promocion.getNombre());
						for (Atraccion atraccion: promocion.getAtracciones()) {
							System.out.println(atraccion.getNombre());
						}
						System.out.println(promocion.getCosto());
						System.out.println(promocion.getTiempo());
						System.out.println(promocion.getCupo());
						System.out.println("Acepta atraccion?\n S N\n");
						eleccion = entrada.next().charAt(0);
						while (eleccion != 'S' && eleccion != 'N') {
							eleccion = entrada.next().charAt(0);
						}
						if (eleccion == 'S') {
							usuario.aceptaPaquete(promocion);
							System.out.println("Aceptada");
						} else {
							System.out.println("Rechazada");
						}
					}
				}
				for (Atraccion atraccion : atracciones) {
					if (usuario.puedeAceptar(atraccion)) {
						System.out.println(atraccion.getNombre());
						System.out.println(atraccion.getCosto());
						System.out.println(atraccion.getTiempo());
						System.out.println(atraccion.getCupo());
						System.out.println("Acepta atraccion?\n S N\n");
						eleccion = entrada.next().charAt(0);
						while (eleccion != 'S' && eleccion != 'N') {
							eleccion = entrada.next().charAt(0);
						}
						if (eleccion == 'S') {
							usuario.aceptaPaquete(atraccion);
							System.out.println("Aceptada");
						} else {
							System.out.println("Rechazada");
						}
					}
				}
			}
			entrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
