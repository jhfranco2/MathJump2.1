package implementación;

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
    public static void main(String[] args) {
		launch(args);
	}
    // metodo necesario para iniciar el juego.
	@Override
	public void start(Stage ventana) throws Exception {
		
		inicializarComponentes();
		gestionEventos();
		pintar();
		//asignar escena a la ventana
		ventana.setScene(escena);
		//asigna titulo para la ventana.
		ventana.setTitle("Super juego");
		//muestra la ventana
		ventana.show();
	}
	//sirve para inicializar los componentes.
	public void inicializarComponentes() {
		root = new Group();
		escena = new Scene(root,700,500);
		lienzo = new Canvas(700,500);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
		
		
	}
	//sirve para pintar la interface.
  public void pintar () {
	  //un rectangulo para hubicar a halo.
	  graficos.fillRect(0, 0, 90,70);
	  //para la imagen de halo.
	  graficos.drawImage(new Image("halo1.2.png"), x, 0);
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
		       x = x+10;
		       System.out.println("Se presiono la tecla:" + evento.getCode());
		       System.out.println("x :" + x);
		       //cambio
		       
		       
		       
		       break;
		       
		    
		    }
		}
    	
    });
  }
}