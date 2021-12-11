package clases;

import implementación.juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Jugador extends ObjetoJuego{
//definiendo atributos	
	private int vidas;
	
	//metodo constructor
	
	

	public Jugador(int x, int y, String nombreImagen, int velocidad, int vidas) {
		super(x, y, nombreImagen, velocidad);
		this.vidas = vidas;
	}

	
	

	

	

	

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	

    //metodo para pintar
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage (juego.imagenes.get(nombreImagen),x,y);
	}
	//Se ejecuta por cada iteracion del ciclo de juego.
	@Override
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
