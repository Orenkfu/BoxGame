package myGame;

import weapons.Weapon;

public class Monster extends HostileNPC {
	private Weapon weapon;

	public Monster(int hp, int basic_attack, int speed) {
		super(hp, basic_attack, speed);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "|name: " + this.getName() + "| HP: " + this.getHP() + "| basic attack: " + this.getBasic_attack()
				+ "| speed: " + this.getSpeed() + "| Status: " + this.getStatus() + "|";
	}

}
