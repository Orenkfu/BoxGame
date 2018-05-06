package hero;

import heroProperties.Inventory;
import myGame.Attacker;
import myGame.ObjectType;
import myGame.battle.Projectile;
import weapons.Weapon;

public class Hero extends Player implements Attacker {
	public Hero(int x, int y, ObjectType objType) {
		super(x, y, objType);
	}

	private Inventory inventory;
	private Weapon weapon;
	private int baseDamage;
	private int totalDamage;
	private int speed;

	@Override
	public void attack() {
		Projectile projectile = new Projectile(x, y, ObjectType.INANIMATE, this);
		projectile.project();

	}

}
