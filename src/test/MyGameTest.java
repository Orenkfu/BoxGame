package test;

import java.util.Random;

import engage.battle.BattleGround;
import myGame.Monster;

public class MyGameTest {
	public static void main(String[] args) throws InterruptedException {
		Monster firstH = new Monster(99, 11, 4);
		firstH.setName("Bobby");
		System.out.println("firstH's basic attack: " + firstH.getBasic_attack());
		Monster secondH = new Monster(34, 12, 2);
		secondH.setName("Eithan");
		BattleGround bg = new BattleGround();
		// Monster winner = (Monster) bg.NPCFight(firstH, secondH);
		// System.out.println(winner);
		Random rand = new Random();

		bg.Recursive();

	}
}
