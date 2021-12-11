package clases;



import javafx.scene.shape.Rectangle;

public class Animacion {
	//cuanto va a durar la animación
  private double duracion;
  //coordenadas de fragmentos, se utiliza un objeto propio de java fx llamado rectangle
  private Rectangle [] coordenadas;
public Animacion(double duracion, Rectangle[] coordenadas) {
	super();
	this.duracion = duracion;
	this.coordenadas = coordenadas;
}
public double getDuracion() {
	return duracion;
}
public void setDuracion(int duracion) {
	this.duracion = duracion;
}
public Rectangle[] getCoordenadas() {
	return coordenadas;
}
public void setCoordenadas(Rectangle[] coordenadas) {
	this.coordenadas = coordenadas;
}
public Rectangle calcularFrameActual(double t) {
	int cantidadFrames = this.coordenadas.length;
	//formula que en base en el tiempo y la duración y la cantidad de objetos de tipo Rectangle calcule cual es el frame que va a imprimir
	int indiceFrameActual = (int)(t%(cantidadFrames*duracion));
	return coordenadas[indiceFrameActual];
}
}