package battleSystem;

import java.util.concurrent.TimeUnit;

import myGame.HostileNPC;

public class AttackSequence {
	/**
	 * when this boolean is true, attacker is ready.
	 */
	private boolean isReady;
	private int Speedcounter;

	public AttackSequence() {
		setReady(false);
	}

	/**
	 * increments Speed counter by 1 on each call - if speedcounter equals method
	 * callers Speed attribute, will set Ready boolean to signal attack readiness.
	 * 
	 * @param attacker
	 * @throws InterruptedException
	 */
	public void speedSequence(HostileNPC attacker) throws InterruptedException {
		if (!this.isReady) {
			TimeUnit.MILLISECONDS.sleep(500);
			this.Speedcounter++;
			if (Speedcounter == attacker.getSpeed()) {
				attackReady();
				this.Speedcounter = 0;
			}
		}
	}

	private void attackReady() {
		setReady(true);

	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

}
