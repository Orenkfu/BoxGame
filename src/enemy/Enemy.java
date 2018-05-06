package enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import myGame.GameObject;
import myGame.ObjectType;
import system.GameLoop;

public class Enemy extends GameObject {

	public Enemy(int x, int y, ObjectType objType) {
		super(x, y, objType);
		// TODO Auto-generated constructor stub
	}

	private void screenVerticalBoundary() {
		x = GameLoop.clamp(x, 0, GameLoop.WIDTH - 50);
	}

	private void screenHorizontalBoundary() {
		y = GameLoop.clamp(y, 0, GameLoop.HEIGHT - 70);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		screenVerticalBoundary();
		screenHorizontalBoundary();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 32, 32);

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
