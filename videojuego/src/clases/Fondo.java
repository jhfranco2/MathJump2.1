package clases;

import implementación.juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego{

	private String nombreImagen2;
	private int x2;
    
	public Fondo(int x, int y, String nombreImagen,String nombreImagen2,int velocidad) {
		super(x, y, nombreImagen, velocidad);
		this.nombreImagen2=nombreImagen2;
		this.ancho = (int)juego.imagenes.get("fmarino1").getWidth();
		this.alto = (int)juego.imagenes.get("fmarino1").getHeight();
	    this.x2=this.ancho + this.x;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		
		graficos.drawImage(juego.imagenes.get(this.nombreImagen), this.x,this.y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen2), this.x2 , this.y);
	}

	@Override
	public void mover() {
		if(x <= -1*ancho) {
			x=ancho;
		}if(x2 <= -1*ancho) {
			x2=ancho;
		}
		if (juego.derecha) {
			
			x-=velocidad;
			x2-=velocidad;
			
		}
		
		
		if(juego.izquierda) {
			x+=velocidad;
			x2+=velocidad;
		}
	}
  
  
}
