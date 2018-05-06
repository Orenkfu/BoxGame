package myGame.battle;

import myGame.Attacker;
import myGame.HostileNPC;
import myGame.NPCStatus;

public class EndEngageCondition {
	/**
	 * returns false if fight end condition is met, true otherwise.
	 */
	public boolean fightEndResult(HostileNPC firstNPC, HostileNPC secondNPC) {
		firstNPC.setDeadByHP();
		secondNPC.setDeadByHP();
		if (NPCStatus.DEAD.equals(firstNPC.getStatus()) || NPCStatus.DEAD.equals(secondNPC.getStatus())) {
			return false;
		}

		return true;

	}

	public boolean fightEndResult(Attacker firstHostile, Attacker secondHostile) {
		if (firstHostile instanceof HostileNPC || secondHostile instanceof HostileNPC)
			((HostileNPC) firstHostile).setDeadByHP();
		((HostileNPC) secondHostile).setDeadByHP();
		if (NPCStatus.DEAD.equals(((HostileNPC) firstHostile).getStatus())
				|| NPCStatus.DEAD.equals(((HostileNPC) secondHostile).getStatus())) {
			return false;
		}

		return true;

	}

}
