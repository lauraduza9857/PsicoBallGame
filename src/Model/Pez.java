package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Pez extends Enemigo {

	public Pez(PApplet app, int x, int y, PImage imagen) {
		super(app, x, y, imagen);
		// TODO Auto-generated constructor stub
		enemigo = app.loadImage("Pez1.png");
		vel = 2;
	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		app.image(enemigo, x, y);
	}

}
