package system;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import myGame.GameObject;
import myGame.ObjectType;

public class Handler {
	private static Handler instance = null;
	// private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private HashMap<ObjectType, GameObject> gameObjects = new HashMap<ObjectType, GameObject>();

	private Handler() {

	}

	public synchronized static Handler getInstance() {
		if (instance == null)
			instance = new Handler();
		return instance;
	}

	public synchronized void tick() {
		Iterator<Entry<ObjectType, GameObject>> it = gameObjects.entrySet().iterator();
		while (it.hasNext()) {
			Entry<ObjectType, GameObject> pair = it.next();
			GameObject gameObject = pair.getValue();
			gameObject.tick();
		}
	}

	public synchronized void render(Graphics g) {
		Iterator<Entry<ObjectType, GameObject>> it = gameObjects.entrySet().iterator();
		while (it.hasNext()) {
			Entry<ObjectType, GameObject> pair = it.next();
			GameObject gameObject = pair.getValue();
			gameObject.render(g);
		}

	}

	public synchronized void addObject(GameObject object) {
		this.gameObjects.put(object.getObjType(), object);
	}

	public synchronized void removeObject(GameObject object) {
		this.gameObjects.remove(object.getObjType(), object);
	}

	public synchronized HashMap<ObjectType, GameObject> getObjects() {
		return gameObjects;
	}
}
