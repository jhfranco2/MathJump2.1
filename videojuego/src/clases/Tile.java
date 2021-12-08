package clases;

import implementaci�n.juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego {

	private int xImagen;
	private int yImagen;
	private int tipoTile;
	public Tile(int tipoTile,int x, int y, String nombreImagen, int velocidad,int ancho,int alto) {
		super(x, y, nombreImagen, velocidad);
		
		this.alto = alto;
		this.ancho = ancho;
		switch(tipoTile) {
		case 1:
			this.xImagen = 0;
			this.yImagen = 0;
			break;
		case 2:
			this.xImagen = 0;
			this.yImagen = 70;
			break;
		case 3:
			this.xImagen = 0;
			this.yImagen = 140;
			break;
		case 4:
			this.xImagen = 0;
			this.yImagen = 210;
			break;
		case 5:
			this.xImagen = 460;
			this.yImagen = 460;
	        break;
		}
	}

	public int getxImagen() {
		return xImagen;
	}

	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}

	public int getyImagen() {
		return yImagen;
	}

	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(juego.imagenes.get(nombreImagen), xImagen, yImagen,ancho,alto,x,y,ancho,alto);
	}

	@Override
	public void mover() {
		
		
	}
	
	
	
}
