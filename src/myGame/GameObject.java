package myGame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected ObjectType objType;

	public GameObject(int x, int y, ObjectType objType) {
		super();
		this.x = x;
		this.y = y;
		this.objType = objType;
	}

	public abstract void tick();

	public abstract Rectangle getBounds();

	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ObjectType getObjType() {
		return objType;
	}

	public void setObjType(ObjectType objType) {
		this.objType = objType;
	}
}
