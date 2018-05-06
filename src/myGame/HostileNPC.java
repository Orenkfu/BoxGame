package myGame;

import battleSystem.AttackSequence;

public class HostileNPC implements Attacker {
	private NPCStatus status;
	private AttackSequence attackSequence;
	private String name;
	private int HP;
	private int basic_damage;
	private int speed;

	public HostileNPC(String name, int hp, int basic_damage, int speed) {
		attackSequence = new AttackSequence();
		status = NPCStatus.ALIVE;
		this.name = name;
		this.HP = hp;
		this.basic_damage = basic_damage;
		this.speed = speed;
	}

	public HostileNPC() {
		status = NPCStatus.ALIVE;
		attackSequence = new AttackSequence();
	}

	public HostileNPC(int hp, int basic_attack, int speed) {
		this.status = NPCStatus.ALIVE;
		attackSequence = new AttackSequence();
		this.HP = hp;
		this.basic_damage = basic_attack;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getBasic_attack() {
		return basic_damage;
	}

	public void setBasic_attack(int basic_attack) {
		this.basic_damage = basic_attack;
	}

	public NPCStatus getStatus() {
		return status;
	}

	public void setStatus(NPCStatus status) {
		this.status = status;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDeadByHP() {
		int hp = this.getHP();
		if (hp <= 0) {
			this.status = NPCStatus.DEAD;
		}
	}

	private boolean incrementAttackQueue() throws InterruptedException {
		if (attackSequence.isReady()) {
			return true;
		} else
			this.attackSequence.speedSequence(this);
		return false;

	}

	@Override
	public void attack(HostileNPC engagedNPC) throws InterruptedException {
		if (incrementAttackQueue()) {
			engagedNPC.setHP(engagedNPC.getHP() - this.getBasic_attack());
			System.out.println("Attacked " + engagedNPC.getName() + "for " + this.getBasic_attack() + "damage!");
			this.attackSequence.setReady(false);
		} else {
			System.out.println("Cannot attack, still on cooldown.");
		}

	}

}
