package battleSystem;

public class SpellSequence {
	private final static int SPELL_COOLDOWN_TIMER_MAX = 10;
	private int spellIncrementor;
	private boolean isReady;

	public SpellSequence() {
		super();
		this.isReady = false;
	}

	public void incrementSpellSequence() {
		if (spellIncrementor == SPELL_COOLDOWN_TIMER_MAX) {
			spellReady();
			spellIncrementor = 0;
		}
		if (!isReady) {
			spellIncrementor++;
		}
	}

	public boolean isReady() {
		return isReady;
	}

	public void spellReady() {
		setReady(true);

	}

	public int getSpellIncrementor() {
		return spellIncrementor;
	}

	public void setSpellIncrementor(int spellIncrementor) {
		this.spellIncrementor = spellIncrementor;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

}
