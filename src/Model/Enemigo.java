package Model;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Enemigo implements Runnable{

	protected PApplet app;
	protected float x;
	protected float y;
	protected int vel;
	protected PImage enemigo;
	protected boolean isAlive = true;
	PImage bNImage;

	public Enemigo(PApplet app, int x, int y, PImage imagen) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.x = x;
		this.y = y;
		bNImage = imagen;
	}
	
	 public abstract void pintar();

	
	public void mover() {
				if (bNImage.get((int) x + 40, (int) y) == -16777216) {
					vel *= -1;

				}
				
				if (bNImage.get((int) x - 40, (int) y) == -16777216) {
					vel *= -1;
				} 
				x += vel;
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isAlive) {
			try {
				Thread.sleep(25);
				mover();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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

	public boolean getIsAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	

}
