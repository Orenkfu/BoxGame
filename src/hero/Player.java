package hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Random;

import myGame.GameObject;
import myGame.ObjectType;
import system.GameLoop;
import system.Handler;
import system.Timer;

public class Player extends GameObject {

	private Health health;
	private Handler handler;
	/** this boolean is true when player takes a hit */
	private boolean isHit;
	private Timer timer;

	public Health getHealth() {
		return health;
	}

	public int getCurrentHealth() {
		return health.getCurrentHealth();
	}

	public void setCurrentHealth(int health) {
		this.health.setCurrentHealth(health);
	}

	// for test
	public Random rand;

	public Player(int x, int y, ObjectType objType) {
		super(x, y, objType);
		this.health = new Health();
		handler = Handler.getInstance();
		this.isHit = false;
		// rand = new Random();
		// for test

	}

	private void screenVerticalBoundary() {
		x = GameLoop.clamp(x, 0, GameLoop.WIDTH - 50);
	}

	private void screenHorizontalBoundary() {
		y = GameLoop.clamp(y, 0, GameLoop.HEIGHT - 70);
	}

	@Override
	public void tick() {
		isHit = false;
		x += velX;
		y += velY;
		screenVerticalBoundary();
		screenHorizontalBoundary();
		HashMap<ObjectType, GameObject> gameObjects = handler.getObjects();
		for (ObjectType type : gameObjects.keySet()) {
			if (ObjectType.ENEMY.equals(type)) {
				GameObject object = gameObjects.get(type);
				if (this.hits(getBounds(), object.getBounds())) {
					this.setCurrentHealth(this.getCurrentHealth() - 2);
					isHit = true;

				}
			}
			if (this.getCurrentHealth() <= 0)
				System.exit(0);
		}
	}

	// for (GameObject object : handler.getObjects()) {
	// if (ObjectType.ENEMY.equals(object.getObjType())) {
	// if (this.hits(getBounds(), object.getBounds())) {
	// this.setCurrentHealth(this.getCurrentHealth() - 2);
	// isHit = true;
	//
	// }
	//

	private void highlight(Graphics g) {
		timer = new Timer(200);
		timer.start();
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public void render(Graphics g) {
		if (isHit) {
			// System.out.println("tried to turn orange");
			highlight(g);
			if (timer.isExpired())
				g.setColor(Color.white);
			g.fillRect(x, y, 32, 32);
		} else {
			g.setColor(Color.white);
			g.fillRect(x, y, 32, 32);
		}
	}

	public void moveUp() {
		this.setVelY(-3);
	}

	public void moveDown() {
		this.setVelY(3);
	}

	public void moveLeft() {
		this.setVelX(-3);
	}

	public void moveRight() {
		this.setVelX(3);
	}

	public boolean hits(Rectangle playerR, Rectangle enemyR) {
		if (playerR.intersects(enemyR))
			return true;
		return false;

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
