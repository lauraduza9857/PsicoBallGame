package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica extends Thread {

	private PApplet app;
	private int pantalla;
	private PImage registro;
	private PImage menu;
	private PImage nivel1;
	private PImage nivel1BN;
	private PImage resumen;
	private String username = "";
	private User dataUser;
	private boolean editUserName = false;
	private Jugador jugador;
	private ArrayList<Enemigo> enemigos;
	private Llave llave;
	private int segundos = 0;
	private int minutos = 0;
	private int nivel;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		registro = app.loadImage("username.png");
		menu = app.loadImage("MENU.png");
		nivel1 = app.loadImage("Nivel1.png");
		nivel1BN = app.loadImage("nivel1-blanconegro.png");
		resumen = app.loadImage("Resume.png");
		pantalla = 0;
		enemigos = new ArrayList<Enemigo>();
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
			if (jugador != null) {
				jugador.pintar();
			}

			if (llave != null) {
				llave.pintar();
			}
			if (enemigos != null) {
				for (int i = 0; i < enemigos.size(); i++) {
					enemigos.get(i).pintar();
				}
			}
			app.fill(255);
			app.text(nivel, 880, 62);
			app.text(dataUser.getPuntaje(), 1042, 62);
			app.text(minutos + " : " + segundos, 1212, 62);
		case 3:
			// Aquí va el nivel 2
			break;
		case 4:
			// Aquí va el nivel 3
			break;
		case 5:
			// Aquí va el nivel 4
			break;

		case 6:
			app.image(resumen, app.width / 2, app.height / 2);
			app.text(dataUser.getUsername(), 235, 341);
			app.text(dataUser.getPuntaje(), 438, 341);
			app.text(minutos + " : " + segundos, 624, 341);
			app.text(dataUser.getDate(), 821, 341);
			break;
		default:
			break;
		}
	}

	public void validarColission() {
		if (jugador != null) {
			for (int i = 0; i < enemigos.size(); i++) {
				Enemigo n = enemigos.get(i);
				if (app.dist(jugador.getX(), jugador.getY(), n.getX(), n.getY()) < 40) {
					jugador.setAlive(false);
				}
			}
			if (llave != null) {
				if (app.dist(jugador.getX(), jugador.getY(), llave.getX(), llave.getY()) < 40) {
					int puntaje = dataUser.getPuntaje();
					dataUser.setPuntaje( puntaje += 20);
					jugador.setHavingKey(true);
					llave = null;
				}
			}
			// metodo para ganar solo duplicar y colocar cordenadas de la puerta
			switch (pantalla) {
			case 2:
				if (jugador.getX() > 1140 && jugador.getX() < 1270 && jugador.getY() > 345 && jugador.getY() < 565 && jugador.isHavingKey()) {
					jugador = null;
					enemigos = null;
					pantalla = 3;
				}

				break;

			default:
				break;
			}
		}
	}

	public void playerIsAlive() {
		if (jugador != null) {
			if (!jugador.getIsAlive()) {
				pantalla = 6;
				jugador = null;
				enemigos = null;
			}
		}
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
				validarColission();
				playerIsAlive();
				Thread.sleep(1000);
				if (pantalla >= 2 && pantalla != 6) {
					segundos++;
					if (segundos >= 60) {
						segundos = 0;
						minutos ++;
					}
					
				}
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
				Enemigo e = new Pez(app, 485, 565, nivel1BN);
				Thread nT = new Thread(e);
				nT.start();
				enemigos.add(e);
				llave = new Llave(app, 650, 230);
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
