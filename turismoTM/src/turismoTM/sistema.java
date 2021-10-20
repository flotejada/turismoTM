package turismoTM;

import java.util.Scanner;

public class sistema {

	public static void main (String[] args) {
		Atraccion atracciones[]= new Atraccion[10];
		atracciones[0]= new Atraccion (10,1,15,"montaña");
		atracciones[1]= new Atraccion(9,5,20,"minas");
		atracciones[2]= new Atraccion(30,2,5,"rio");
		
		Usuario usuario[]= new Usuario[2];
		usuario[0]= new Usuario("Pepe",100,5);
		usuario[1]= new Usuario("Paco",50,10);
		
		int i,j; 
		char eleccion;
		
		Scanner entrada = new Scanner(System.in);
		
		for(j=0;j<2;j++) {
			System.out.println(usuario[j].getNombre());
			for (i=0;i<3;i++) {
				if (usuario[j].puedeAceptar(atracciones[i])) {
					System.out.println(atracciones[i].getNombre());
					System.out.println(atracciones[i].getCosto());
					System.out.println(atracciones[i].getTiempo());
					System.out.println(atracciones[i].getCupo());
					System.out.println("Acepta atraccion?\n S N\n");
					eleccion= entrada.next().charAt(0);
					if(eleccion=='S') {
						usuario[j].aceptaAtraccion(atracciones[i]);
						System.out.println("Aceptada");
					} else {
						System.out.println("Rechazada");
					}
				}
			}
		}
		
	}
}
