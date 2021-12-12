package clases;

import implementación.juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego {
public int xImagen ;
public int yImagen ;
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
			this.xImagen = 1;
			this.yImagen = 723;
			break;
		case 3:
			this.xImagen = 69;
			this.yImagen = 201;
			break;
		case 4:
			this.xImagen = 528;
			this.yImagen = 525;
			break;
		case 5:
			this.xImagen = 461;
			this.yImagen = 526;
			break;
		case 6:
			this.xImagen= 525;
			this.yImagen = 657;
			break;
		case 7:
			this.xImagen = 259;
			this.yImagen = 201;
			break;
		case 8:
			this.xImagen = 397; 
			this.yImagen = 726;
			break;
		case 9:
			this.xImagen = 528;
			this.yImagen = 723;
			break;
		case 10:
			this.xImagen =461;
			this.yImagen =1;
			break;
		}
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(juego.imagenes.get(nombreImagen), xImagen, yImagen,ancho,alto,x,y,ancho,alto);
	}

	@Override
	public void mover() {
		
		
	}
	
	
	
}
