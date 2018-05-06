package system;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import hero.Health;
import hero.Player;
import myGame.GameObject;
import myGame.ObjectType;

public class HUD extends GameObject {
	Player player;
	private int health;

	public HUD(int x, int y, ObjectType objType) {
		super(x, y, objType);

	}

	public HUD(int x, int y, ObjectType objType, Player player) {
		super(x, y, objType);
		this.player = player;
		this.health = player.getHealth().getCurrentHealth();
	}

	public void tick() {
		health = player.getCurrentHealth();
		health = GameLoop.clamp(health, 0, Health.getMaxHealth());

	}

	public void render(Graphics g) {

		g.setColor(Color.gray);
		g.fillRect(15, 15, Health.getMaxHealth() * 2, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, (health * 2), 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
