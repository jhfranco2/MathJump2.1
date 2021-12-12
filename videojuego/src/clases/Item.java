package clases;

import implementación.juego;
import javafx.scene.canvas.GraphicsContext;

public class Item extends ObjetoJuego {
    private int cantidadPuntos;
	public Item(int x, int y, String nombreImagen, int velocidad,int cantidadPuntos) {
		super(x, y, nombreImagen, velocidad);
		this.cantidadPuntos= cantidadPuntos;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(juego.imagenes.get("item"), cantidadPuntos, cantidadPuntos);
		
	}

	@Override
	public void mover() {
	
		
	}

}
