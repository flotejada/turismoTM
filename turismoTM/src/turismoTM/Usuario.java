package turismoTM;

public class Usuario {
String nombre;
float presupuesto;
float tiempo;
public Usuario(String nombre,float presupuesto, float tiempo) {
	super();
	this.nombre= nombre; 
	this.presupuesto = presupuesto;
	this.tiempo = tiempo;
}
public String getNombre(){
	return this.nombre;
}
public void aceptaAtraccion(Atraccion atraccion) {
	this.presupuesto-=atraccion.costo;
	this.tiempo-=atraccion.tiempo;
}
public boolean puedeAceptar(Atraccion atraccion) {
	return ((this.presupuesto>=atraccion.costo)&&(this.tiempo>=atraccion.tiempo)&&(atraccion.cupo>0));
}
}
