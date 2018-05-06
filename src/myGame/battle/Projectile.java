package myGame.battle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import hero.Player;
import myGame.GameObject;
import myGame.ObjectType;

public class Projectile extends GameObject {
	Player player;

	public Projectile(int x, int y, ObjectType objType, Player player) {
		super(x, y, objType);
		this.player = player;
		// TODO Auto-generated constructor stub
	}

	public void project() {
		this.setVelX(player.getVelX());
		this.setVelY(player.getVelY());
	}

	@Override
	public void tick() {
		this.x += this.getVelX();
		this.y += this.getVelY();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 8, 8);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
