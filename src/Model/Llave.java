package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Llave {

	
	private PApplet app;
	private float x;
	private float y;
	private PImage llave;
	
	public Llave(PApplet app, int x, int y) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.x = x;
		this.y = y;
		llave = app.loadImage("LLave.png");
	}
	
	public void pintar() {
		app.image(llave, x, y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	
	
}
