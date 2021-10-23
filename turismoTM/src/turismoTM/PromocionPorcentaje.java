package turismoTM;

import java.util.List;

public class PromocionPorcentaje extends Promocion {

	private float porcentaje;
	
	@Override
	public float getCosto() {
		return super.getCosto() * (1 - porcentaje / 100);
	}

	public PromocionPorcentaje(List<Atraccion> atracciones, String nombre, float porcentaje) {
		super(atracciones, nombre);
		this.porcentaje = porcentaje;
	}
	
}
