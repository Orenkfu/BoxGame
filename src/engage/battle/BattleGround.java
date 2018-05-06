package engage.battle;

import myGame.Attacker;
import myGame.HostileNPC;
import myGame.NPCStatus;
import myGame.battle.EndEngageCondition;

public class BattleGround {
	EndEngageCondition endCondition;
	int counter = 0;

	public HostileNPC NPCFight(Attacker firstHostile, Attacker secondHostile) throws InterruptedException {
		endCondition = new EndEngageCondition();
		while (endCondition.fightEndResult(firstHostile, secondHostile)) {
			firstHostile.attack((HostileNPC) secondHostile);
			secondHostile.attack((HostileNPC) firstHostile);

		}
		System.out.println(firstHostile);
		System.out.println(secondHostile);
		if (NPCStatus.DEAD.equals(((HostileNPC) firstHostile).getStatus())) {
			return (HostileNPC) secondHostile;
		}
		if (NPCStatus.DEAD.equals(secondHostile)) {
			return (HostileNPC) firstHostile;
		}
		return null;
	}

	public void Recursive() {
		System.out.println("counter = " + counter);
		if (counter < 12) {
			counter++;
			Recursive();
		}
	}

}
