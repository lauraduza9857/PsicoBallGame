package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica extends Thread{

	private PApplet app;
	private int pantalla;
	private PImage registro;
	private PImage menu;
	private PImage nivel1;
	private PImage nivel1BN;
	private String username = "";
	private User dataUser;
	private boolean editUserName = false;
	private Jugador jugador;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		registro = app.loadImage("username.png");
		menu = app.loadImage("MENU.png");
		nivel1 = app.loadImage("Nivel1.png");
		nivel1BN = app.loadImage("nivel1-blanconegro.png");
		pantalla = 0;
	}

	public void pintar() {
		switch (pantalla) {
		case 0:
			app.image(registro, app.width / 2, app.height / 2);
			app.fill(0);
			app.textSize(20);
			app.text(username, 640, 624);
			break;
		case 1:
			app.image(menu, app.width / 2, app.height / 2);
			break;
		case 2:
			app.image(nivel1, app.width / 2, app.height / 2);
			jugador.pintar();
			break;

		default:
			break;
		}
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void mousePressed() {
		System.out.println(app.mouseX + ":" + app.mouseY);
		switch (pantalla) {
		case 0:
			if (app.mouseX > 475 && app.mouseX < 815 && app.mouseY > 605 && app.mouseY < 655) {
				editUserName = true;
			}
			if (app.mouseX > 1075 && app.mouseX < 1240 && app.mouseY > 665 && app.mouseY < 700) {
				if (username.length() > 0) {
					String date = LocalDate.now() + "";
					dataUser = new User(username, date);
					pantalla += 1;
				}
			}
			break;
		case 1:
			if (app.mouseX > 420 && app.mouseX < 910 && app.mouseY > 150 && app.mouseY < 230) {
				pantalla += 1;
				jugador = new Jugador(app, 55, 630, nivel1BN);
				jugador.start();
			}
			break;

		default:
			break;
		}
	}

	public void keyTyped() {
		switch (pantalla) {
		case 0:
			if (editUserName) {
				System.out.println("Entro");
				username += app.key;
			}
			break;

		default:
			break;
		}
	}

	public void keyPressed() {
		switch (pantalla) {
		case 2:
			jugador.KeyPressed();
			break;

		default:
			break;
		}
	}

	public void keyReleased() {
		switch (pantalla) {
		case 2:
			jugador.KeyReleased();
			break;

		default:
			break;
		}
	}

}
