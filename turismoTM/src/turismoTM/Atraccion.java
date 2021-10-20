package turismoTM;

public class Atraccion {
float costo;
float tiempo; 
int cupo;
String nombre; 

public Atraccion(float costo, float tiempo, int cupo, String nombre) {
	super();
	this.costo = costo;
	this.tiempo = tiempo;
	this.cupo = cupo;
	this.nombre = nombre;
} 
public String getNombre(){
	return this.nombre;
}
public float getCosto(){
	return this.costo;
}
public float getTiempo(){
	return this.tiempo;
}
public int getCupo(){
	return this.cupo;
}

}
