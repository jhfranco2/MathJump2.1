package clases;
import java.util.ArrayList;
import java.util.HashMap;

import implementación.juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.shape.Rectangle;
	

	
public class JugadorAnimado extends ObjetoJuego{
	//definiendo atributos	
		private int vidas;
		
		private HashMap<String,Animacion> animaciones;
		private int xImagen;
		private int yImagen;
		private int anchoImagen;
		private int altoImagen;
		private String animacionActual;
		private int direccion = 1;
		//metodo constructor
		
		

		public int getDireccion() {
			return direccion;
		}



		public void setDireccion(int direccion) {
			this.direccion = direccion;
		}



		public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int vidas,String animacionActual) {
			super(x, y, nombreImagen, velocidad);
			this.vidas = vidas;
			this.animacionActual = animacionActual;
			animaciones = new HashMap<String,Animacion>();
			inicializarAnimaciones();
		}

		

		public String getAnimacionActual() {
			return animacionActual;
		}



		public void setAnimacionActual(String animacionActual) {
			this.animacionActual = animacionActual;
		}



		public int getVidas() {
			return vidas;
		}

		public void setVidas(int vidas) {
			this.vidas = vidas;
		}

		//se guardaran fragmentos de imagen de la animacion
       public void inicializarAnimaciones() {
    	   
    	   Rectangle coordenadasCorrer[]= {
    	   new Rectangle(246,52,70,68),//293,53 82,83
    	   new Rectangle(302,45,78,68),
    	   new Rectangle(359,49,78,68),
    	   new Rectangle(421,50,78,68),
    	   new Rectangle(471,50,78,68),
    	   new Rectangle(534,49,78,68),
    	   new Rectangle(588,50,78,68),
    	   new Rectangle(646,50,78,68),
    	   new Rectangle(696,49,78,68),
    	   new Rectangle(765,50,78,68)
    	   
       };
    	   Animacion animacionCorrer = new Animacion(0.15,coordenadasCorrer);
           animaciones.put("correr",animacionCorrer);   
           
           Rectangle coordenadasDescanso[] = {
            new Rectangle(246,52,70,68),   
           };
           Animacion animacionDescanso = new Animacion(1,coordenadasDescanso);
           animaciones.put("descanso", animacionDescanso);
       }
       public void calcularFrame(double t) {
    	 Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
    	 this.xImagen = (int)coordenadas.getX();
    	 
    	 this.yImagen = (int)coordenadas.getY();
    	 this.altoImagen = (int)coordenadas.getWidth();
    	 this.anchoImagen = (int)coordenadas.getHeight();
       }
	    //metodo para pintar
		@Override
		public void pintar(GraphicsContext graficos) {
			graficos.drawImage (juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen,altoImagen,x,y,(direccion)*70,70);
			
		 
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
			/*if(juego.arriba) 
				//Mover hacia la arriba
				y-= velocidad;
			if(juego.abajo) 
				//Mover hacia la abajo
				y+= velocidad;
	        	*/		   
		}
	}


