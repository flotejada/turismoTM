package turismoTM;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private float monto;
	
	@Override
	public float getCosto() {
		return this.monto;
	}

	public PromocionAbsoluta(List<Atraccion> atracciones, String nombre, float parseFloat) {
		super(atracciones, nombre);
		this.monto = monto; 
	}

}
