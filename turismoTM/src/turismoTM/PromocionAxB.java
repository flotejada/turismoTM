package turismoTM;

import java.util.ArrayList;
import java.util.List;

public class PromocionAxB extends Promocion {
	
	List<Atraccion> gratis;
	
	@Override
	public float getTiempo() {
		float sum = 0;
		for (Atraccion atraccion: this.gratis) {
			sum += atraccion.getTiempo();
		}
		return sum + super.getTiempo();
	}
	
	@Override
	public int getCupo() {
		int min = this.atracciones.get(0).getCupo();
		for (Atraccion atraccion: this.gratis) {
			if (atraccion.getCupo() < min) {
				min = atraccion.getCupo();
			}
		}
		int minPrimarias = super.getCupo();
		return min < minPrimarias ? min : minPrimarias;
	}

	public PromocionAxB(List<Atraccion> atracciones, String nombre, List<Atraccion> gratis) {
		super(atracciones, nombre);
		
		this.gratis = gratis;
	}
	
	@Override
	public List<Atraccion> getAtracciones() {
		List<Atraccion> atracciones = new ArrayList<>();
		for (Atraccion atraccion: super.getAtracciones()) {
			atracciones.add(atraccion);
		}
		for (Atraccion atraccion: this.gratis) {
			atracciones.add(atraccion);
		}
		return this.atracciones;
	}

}
