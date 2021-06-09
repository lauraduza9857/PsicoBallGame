package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Jugador extends Thread {

	private PApplet app;
	private float x;
	private float y;
	private int vel;
	private float gravedad;
	private PImage bolita;
	private boolean moverI = false;
	private boolean moverD = false;
	private boolean isAlive = true;
	private boolean isTouchingFloor = false;
	PImage bNImage;

	public Jugador(PApplet app, int x, int y, PImage bNImage) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.x = x;
		this.y = y;
		bolita = app.loadImage("Bolita.png");
		vel = 4;
		this.bNImage = bNImage;
	}

	public void pintar() {
		app.image(bolita, x, y);
	}

	public void mover() {
		if (moverD) {
			if (bNImage.get((int) x + 40, (int) y) == -16777216) {

			} else {
				x += vel;
			}
		}
		if (moverI) {
			if (bNImage.get((int) x - 40, (int) y) == -16777216) {

			} else {
				x -= vel;
			}
		}
		if (!isTouchingFloor) {
			gravedad += 0.2f;
			y += gravedad;
		}
	}

	public void validarSuelo() {
		if (bNImage.get((int) x, (int) y + 40) == -16777216) {
			isTouchingFloor = true;
		} else {
			System.out.println(bNImage.get((int) x, (int) y + 80));
			isTouchingFloor = false;
		}
	}

	public void KeyPressed() {
		if (app.keyCode == app.RIGHT) {
			moverI = false;
			moverD = true;
		}
		if (app.keyCode == app.LEFT) {
			moverI = true;
			moverD = false;
		}

	}

	public void KeyReleased() {
		if (app.keyCode == app.RIGHT) {
			moverD = false;
		}
		if (app.keyCode == app.LEFT) {
			moverI = false;
		}
		if (app.key == ' ' && isTouchingFloor) {
			gravedad = -11;
			isTouchingFloor = false;
			y += gravedad;
		}
	}

	public void run() {
		while (isAlive) {
			try {
				Thread.sleep(20);
				mover();
				validarSuelo();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
