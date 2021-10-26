package turismoTM;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void noPuedeAceptarAtraccionesLlenas() {
		Usuario flor = new Usuario("Flor", 10, 2);
		Usuario mica = new Usuario("Mica", 15, 3);
		
		Atraccion puente = new Atraccion("Puente", 10, 1, 1);
		
		assertEquals(puente.getCupo(), 1);
		
		flor.aceptaPaquete(puente);
		
		assertEquals(puente.getCupo(), 0);
		assertEquals(flor.getTiempo(), 1);
		
		assertEquals(mica.puedeAceptar(puente), false);
	}
	
	@Test
	void noPuedeAceptarAtraccionesRepetidas() {
		Usuario dario = new Usuario("Darío", 32, 10);
		
		Atraccion puente = new Atraccion("Puente", 12, 1, 3);
		Atraccion isla = new Atraccion("Isla", 8, 2, 5);
		
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(puente);
		atracciones.add(isla);
		Promocion packAhorro = new PromocionPorcentaje(atracciones, "Pack Ahorro", 25);
		
		assertEquals(packAhorro.getCosto(), (puente.getCosto()+isla.getCosto())*0.75);
		
		assertEquals(dario.puedeAceptar(packAhorro), true);
		assertEquals(dario.puedeAceptar(puente), true);
		assertEquals(dario.getPresupuesto(), 32);
		dario.aceptaPaquete(packAhorro);
		assertEquals(dario.puedeAceptar(puente), false);
		assertEquals(dario.getPresupuesto(), 32- packAhorro.getCosto());
		
	}

}
