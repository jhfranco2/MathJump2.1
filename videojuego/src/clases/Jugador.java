package clases;

import implementación.juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Jugador {
//definiendo atributos
	private int x;
	private int y;
	private int vidas;
	private String nombreImagen;
	private int velocidad = 5;
	

	//metodo constructor
	public Jugador(int x, int y, int vidas, String nombreImagen) {
		super();
		this.x = x;
		this.y = y;
		this.vidas = vidas;
		this.nombreImagen = nombreImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

    //metodo para pintar
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage (juego.imagenes.get(nombreImagen),x,y);
	}
	//Se ejecuta por cada iteracion del ciclo de juego.
	public void mover() {
		if(x>700)
			x = -80;
			
		if(juego.derecha) 
			//Mover hacia la derecha
			x+= velocidad;
		if(juego.izquierda) 
			//Mover hacia la izquierda
			x-= velocidad;
		if(juego.arriba) 
			//Mover hacia la arriba
			y-= velocidad;
		if(juego.abajo) 
			//Mover hacia la abajo
			y+= velocidad;
	}
}
