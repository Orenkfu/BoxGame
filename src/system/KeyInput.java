package system;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import hero.Hero;
import myGame.GameObject;
import myGame.ObjectType;

public class KeyInput extends KeyAdapter {
	private String name;
	private Handler handler;

	public KeyInput() {
		this.handler = Handler.getInstance();
		this.name = "MyKeyInput";
	}

	public String getName() {
		return name;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		HashMap<ObjectType, GameObject> gameObjects = handler.getObjects();
		for (ObjectType type : gameObjects.keySet()) {
			if (ObjectType.PLAYER.equals(type)) {
				GameObject object = gameObjects.get(type);
				Hero player = (Hero) object;
				if (key == KeyEvent.VK_W) {
					System.out.println("w pressed.");
					player.moveUp();
				}
				if (key == KeyEvent.VK_S) {
					player.moveDown();
				}
				if (key == KeyEvent.VK_A) {
					player.moveLeft();
				}
				if (key == KeyEvent.VK_D) {
					player.moveRight();
				}
				if (key == KeyEvent.VK_SPACE) {
					System.out.println("attacking enemy..");
					player.attack();
				}

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("a key was released..");
		HashMap<ObjectType, GameObject> gameObjects = handler.getObjects();
		for (ObjectType type : gameObjects.keySet()) {
			if (ObjectType.PLAYER.equals(type)) {
				GameObject object = gameObjects.get(type);
				Hero player = (Hero) object;
				if (key == KeyEvent.VK_W) {
					System.out.println("w released");
					// System.out.println("im here");
					player.setVelY(0);
				}
				if (key == KeyEvent.VK_S) {
					player.setVelY(0);
				}
				if (key == KeyEvent.VK_A) {
					player.setVelX(0);
				}
				if (key == KeyEvent.VK_D) {
					player.setVelX(0);
				}
				if (key == KeyEvent.VK_SPACE) {

				}
			}

		}

	}
}
