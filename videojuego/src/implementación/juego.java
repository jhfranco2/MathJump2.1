package implementación;

import java.util.HashMap;

import clases.Jugador;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class juego extends Application{

	private GraphicsContext graficos;
	// variable rama.
    private	Group root; 
    // para la escena del juego.
    private Scene escena;
    // para pintar .
    private Canvas lienzo;
    //Método main ejecuta el metodo lauch.
	private int x = 0;
	//se define al jugador.
	private Jugador jugador;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	//todas las imagenes quedaran guardadas aqui.
	public static HashMap<String, Image> imagenes;
	
    public static void main(String[] args) {
		launch(args);
	}
    // metodo necesario para iniciar el juego.
	@Override
	public void start(Stage ventana) throws Exception {
		
		inicializarComponentes();
		gestionEventos();
		
		//asignar escena a la ventana
		ventana.setScene(escena);
		//asigna titulo para la ventana.
		ventana.setTitle("Super juego");
		//muestra la ventana
		ventana.show();
		cicloJuego();
	}
	public void cicloJuego() {
		long timeInicial = System.nanoTime();
		//sirve para pintar una imagen 60 veces por segundo o dependeiendo del rendimiento de la computadora.
		AnimationTimer animationTimer = new AnimationTimer() {

			//este metodo se ejecuta 60 veces por segundo o 60 fps.
			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual - timeInicial) / 1000000000.0 ;
				System.out.println(t);
				actualizarEstado();
				pintar();
			}
			
		};
		animationTimer.start();//En esta linea empieza el ciclo de juego
	}
	//logica del juego.
	public  void actualizarEstado(){
		jugador.mover();
	}
	//sirve para inicializar los componentes.
	public void inicializarComponentes() {
		imagenes = new HashMap<String, Image>();
		cargarImagenes();
		jugador = new Jugador(20,40,3,"halo");
		root = new Group();
		escena = new Scene(root,700,500);
		lienzo = new Canvas(700,500);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
		
		
	}
	
	public void cargarImagenes() {
	    imagenes.put("halo", new Image("halo1.2.png"));	
	}
	//sirve para pintar la interface.
  public void pintar () {
	  //un rectangulo para hubicar a halo.
	  //graficos.fillRect(0, 0, 90,70);
	  //para la imagen de halo.
	  graficos.drawImage(new Image("fmarino1.jpg"), 0, 0);
	  jugador.pintar(graficos);
	  
}
  //Controlara lo que hace el personaje.
  public void gestionEventos() {
	  //Registrando el evento cuando se presiona una tecla
	// escena.setOnKeyPressed(new Evento());  
    escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
    	
        //El metodo handle se ejecuta cada vez que presiono una tecla
		@Override
		public void handle(KeyEvent evento) {
				
		    switch(evento.getCode().toString()) {
		        case "RIGHT":
		            derecha = true;
		            break;
		        case "LEFT":
		    	    izquierda = true;
		           	break;
		        case "UP":
		    	    arriba = true;
		    	    break;
		        case "DOWN":
		    	    abajo = true;
		    	    break;
		        case "SPACE":
		        	jugador.setVelocidad(10);
		        	break;
		        	
		    }
		}
    	
    });
    
    escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
     
    	
    	//Se ejecuta cuando se suelta una tecla
		@Override
		public void handle(KeyEvent evento) {
			switch(evento.getCode().toString()) {
	        case "RIGHT":
	            derecha = false;
	            break;
	        case "LEFT":
	    	    izquierda = false;
	           	break;
	        case "UP":
	    	    arriba = false;
	    	    break;
	        case "DOWN":
	    	    abajo = false;
	    	    break;
	        case "SPACE":
	        	jugador.setVelocidad(5);
	        	
			}
		}
    	
    });
  }
  
}