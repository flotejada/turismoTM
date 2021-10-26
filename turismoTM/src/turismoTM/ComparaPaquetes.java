package turismoTM;

//Java program to demonstrate working of Comparator
//interface
import java.util.Comparator;

public class ComparaPaquetes implements Comparator<Paquete> {

	@Override
	public int compare(Paquete p1, Paquete p2) {
		float diffCosto = p2.getCosto() - p1.getCosto();
		
		if (diffCosto > 0) return 1;
		if (diffCosto < 0) return -1;
		
		// Los costos son los mismos. Comparar por tiempo
		float diffTiempo = p2.getCosto() - p1.getCosto();
		
		if (diffTiempo > 0) return 1;
		if (diffTiempo < 0) return -1;
		return 0;
	}

}
