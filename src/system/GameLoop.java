package system;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import enemy.BasicEnemy;
import hero.Hero;
import myGame.ObjectType;

public class GameLoop extends Canvas implements Runnable {

	private static final long serialVersionUID = -1114715943502643526L;
	boolean running = false;
	private Thread gameLoop;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Handler handler;
	public static final int GROUND = HEIGHT - 160;
	private HUD hud;
	Random rand;

	public GameLoop() {
		handler = Handler.getInstance();
		// handler = Handler.getInstance();
		new Window(WIDTH, HEIGHT, "My Game!", this);
		rand = new Random();
		Hero player = new Hero(WIDTH / 3 - 32, HEIGHT / 3 - 32, ObjectType.PLAYER);
		hud = new HUD(WIDTH / 3 - 32, GROUND, ObjectType.INANIMATE, player);
		handler.addObject(player);
		handler.addObject(hud);
		// handler.addObject(new Projectile(player.getX(), player.getY(),
		// ObjectType.INANIMATE, player));
		for (int i = 0; i < 10; i++) {
			handler.addObject(new BasicEnemy(rand.nextInt(WIDTH), rand.nextInt(HEIGHT), ObjectType.ENEMY, player));

		}

		System.out.println("player health is: " + player.getCurrentHealth());
		this.addKeyListener(new KeyInput());

		// for testing
		// KeyListener[] listeners = this.getKeyListeners();
		// for (KeyListener keyListener : listeners) {
		// if (keyListener instanceof KeyInput) {
		// ((KeyInput) keyListener).getName();
		// }
		// System.out.println(((KeyInput) keyListener).getName());
		// }
		System.out.println(handler.getObjects());
		// end testing

		// for testing

	}

	private void stop() {
		try {
			gameLoop.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void start() {
		gameLoop = new Thread(this);
		gameLoop.start();
		running = true;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		hud.render(g);

		g.dispose();
		bs.show();

	}

	public static int clamp(int locationCheck, int minLocation, int maxLocation) {
		if (locationCheck >= maxLocation)
			return locationCheck = maxLocation;
		else if (locationCheck <= minLocation)
			return locationCheck = minLocation;
		else
			return locationCheck;
	}

	public static void main(String args[]) {
		new GameLoop();
	}
}
