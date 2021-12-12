package clases;

import javafx.scene.canvas.GraphicsContext;
//Se le indica a el objeto juego los atributos y metodos que heredara a los hijos.
public abstract class ObjetoJuego {
public int x ;
public int y ;
public String nombreImagen ;
public int velocidad  ;
	protected int ancho;
	protected int alto;
	
	public ObjetoJuego(int x, int y, String nombreImagen, int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.nombreImagen = nombreImagen;
		this.velocidad = velocidad;
	}

	public abstract void pintar(GraphicsContext graficos);
	
	public abstract void mover();
	
}
