package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Pez2 extends Enemigo {

	public Pez2(PApplet app, int x, int y, PImage imagen) {
		super(app, x, y, imagen);
		// TODO Auto-generated constructor stub
		enemigo = app.loadImage("Pez2.png");
		vel = 3;
	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		app.image(enemigo, x, y);
	}

}
