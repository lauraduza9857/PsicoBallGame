package View;

import Controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {

	Controller controller;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("View.Main");

	}

	public void settings() {
		size(1280, 720);
		
	}

	@Override
	public void setup() {
		textAlign(CENTER, CENTER);
		rectMode(CENTER);
		ellipseMode(CENTER);
		imageMode(CENTER);
		controller = new Controller(this);

	}

	@Override
	public void draw() {
		background(255);
		controller.pintar();
	}

	@Override
	public void mousePressed() {
		controller.mousePressed();
	}

	@Override
	public void keyTyped() {
		controller.keyTyped();
	}
	
	@Override
	public void keyPressed() {
		controller.keyPressed();
	}
	@Override
	public void keyReleased() {
		controller.keyReleased();
	}
}
