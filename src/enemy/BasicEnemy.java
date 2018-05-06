package enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import hero.Player;
import myGame.ObjectType;
import myGame.Trail;
import system.GameLoop;
import system.Handler;

public class BasicEnemy extends Enemy {
	Random rand;
	Handler handler;
	Player player;

	public BasicEnemy(int x, int y, ObjectType objType, Player player) {
		super(x, y, objType);
		this.handler = Handler.getInstance();
		rand = new Random();
		velY = rand.nextInt(7) + 1;
		velX = rand.nextInt(7) + 1;
		this.player = player;
	}

	private void screenVerticalBoundary() {
		x = GameLoop.clamp(x, 0, GameLoop.WIDTH - 50);
	}

	private void screenHorizontalBoundary() {
		y = GameLoop.clamp(y, 0, GameLoop.HEIGHT - 70);
	}

	private void bounceOverWalls() {
		if (y <= 0 || y >= GameLoop.HEIGHT - 32)
			velY = -velY;

		if (x <= 0 || x >= GameLoop.WIDTH - 32)
			velX = -velX;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		handler.addObject(new Trail(x, y, 16, 16, 0.1f, Color.red, ObjectType.INANIMATE, handler));
		// wabounceOffPlayer(player);
		bounceOverWalls();
	}

	public void bounceOffPlayer(Player player) {
		if (this.getBounds().intersects(player.getBounds())) {

			setVelX(-this.velX);
			setVelY(-this.velY);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, 16, 16);
	}
}
