package myGame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import system.Handler;

public class Trail extends GameObject {
	private float alpha;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	private float lifeCycle;

	public Trail(int x, int y, int width, int height, float lifeCycle, Color color, ObjectType objType,
			Handler handler) {
		super(x, y, objType);
		this.handler = Handler.getInstance();
		this.alpha = 1;
		this.color = color;
		this.width = width;
		this.height = height;
		this.lifeCycle = lifeCycle;
	}

	@Override
	public void tick() {
		if (alpha > lifeCycle) {
			alpha -= (lifeCycle - 0.001f);
		} else {
			handler.removeObject(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));

	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));

		g2d.setColor(this.color);

		g2d.fillRect(x, y, width, height);

		g2d.setComposite(makeTransparent(1));
	}

}
