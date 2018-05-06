package myGame.battle;

import java.util.Random;

import hero.Hero;
import myGame.Monster;
import weapons.Weapon;

public class Damage {
	private final int MIN_DAMAGE_ROLL = 1;
	private final int TOP_DAMAGE_ROLL = 100;
	private int finalDamage;

	public int getFinalDamage() {
		return finalDamage;
	}

	public void setFinalDamage(int finalDamage) {
		this.finalDamage = finalDamage;
	}

	private Hero hero;
	// private HostileNPC hostile;
	private Random rand;

	public Damage(Hero hero) {
		super();
		this.hero = hero;
	}

	public Damage(Monster hostile) {
		super();
		rand = new Random();
		finalDamage = calculateDamage(hostile);
	}

	private int calculateDamage(Monster hostile) {
		int currentDamage = 0;
		Weapon weapon = hostile.getWeapon();
		int minDmg = weapon.getMinDamage();
		int maxDmg = weapon.getMaxDamage();
		currentDamage = rand.nextInt(maxDmg) + minDmg;
		currentDamage += hostile.getBasic_attack();

		return currentDamage;

	}
}
