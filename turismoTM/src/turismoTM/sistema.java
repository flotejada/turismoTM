package turismoTM;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;



public class sistema {
	public static void main(String[] args) {
		try {
			List<Atraccion> atracciones = Atraccion.lector("C:\\Users\\lesch\\Documents\\turismoTM\\turismoTM\\atracciones.csv");
			List<Usuario> usuarios = Usuario.lector("C:\\Users\\lesch\\Documents\\turismoTM\\turismoTM\\usuarios.csv");
			List<Promocion> promociones = Promocion.lector("C:\\Users\\lesch\\Documents\\turismoTM\\turismoTM\\promociones.csv",atracciones);
		
			
			char eleccion;
			
			atracciones.sort(new ComparaPaquetes());
			promociones.sort(new ComparaPaquetes());

			Scanner entrada = new Scanner(System.in);
			
			
			System.out.println("---BIENVENIDOS AL SISTEMA DE TURISMO EN LA TIERRA MEDIA---\n");

			for (Usuario usuario : usuarios) {
				System.out.print("Hola ");
				System.out.println(usuario.getNombre());
				System.out.print("Te mostraremos opciones para que planifiques tu visita\n");
				System.out.print("Empecemos!\n");
				for (Promocion promocion: promociones) {
					if (usuario.puedeAceptar(promocion)) {
						System.out.println(promocion.getNombre());
						for (Atraccion atraccion: promocion.getAtracciones()) {
							System.out.println(atraccion.getNombre());
						}
						System.out.println(promocion.getCosto());
						System.out.println(promocion.getTiempo());
						System.out.println(promocion.getCupo());
						System.out.println("Deseas aceptar la atraccion?\n S N\n");
						eleccion = entrada.next().charAt(0);
						while (eleccion != 'S' && eleccion != 'N') {
							eleccion = entrada.next().charAt(0);
						}
						if (eleccion == 'S') {
							usuario.aceptaPaquete(promocion);
							System.out.println("Aceptada");
						} else {
							System.out.println("Rechazada,te mostraremos otras opciones");
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
				System.out.println("Gracias por elegirnos, que lo disfrutes");
				System.out.print("----------------------------------------------------------------------\n");
			}
			entrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
