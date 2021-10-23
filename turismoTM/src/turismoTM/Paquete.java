package turismoTM;

import java.util.List;

public abstract class Paquete {

	public abstract float getCosto();
	public abstract int getCupo();
	public abstract float getTiempo();
	
	public abstract void fueAceptadoPor(Usuario usuario);
	
	public abstract List<Atraccion> getAtracciones();
}
