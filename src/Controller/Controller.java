package Controller;

import Model.Logica;
import processing.core.PApplet;

public class Controller {

	Logica logica;
	
	public Controller(PApplet app) {
		// TODO Auto-generated constructor stub
		logica = new Logica(app);
		logica.start();
	}
	
	public void pintar() {
		logica.pintar();
	}
	
	public void mousePressed() {
		logica.mousePressed();
	}
	
	public void keyTyped() {
		logica.keyTyped();
	}
	
	public void keyPressed() {
		logica.keyPressed();
	}
	
	public void keyReleased() {
		logica.keyReleased();
	}

}
