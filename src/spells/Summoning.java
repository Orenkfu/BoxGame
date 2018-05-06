package spells;

import battleSystem.SpellSequence;
import creatures.Familiar;
import exceptions.CooldownException;
import exceptions.ExceptionTypeInterpreter;
import exceptions.ExceptionTypes;
import hero.Mage;

public class Summoning {
	private SpellSequence spellSequence;
	private ExceptionTypeInterpreter exceptionInterpret;

	public Summoning() {
		super();
		spellSequence = new SpellSequence();
		exceptionInterpret = new ExceptionTypeInterpreter();
	}

	private Familiar summonFamiliar(Mage mage) throws CooldownException {
		Familiar familiar = null;
		if (this.spellSequence.isReady()) {
			familiar = new Familiar();
		} else {

			String exceptionMessage = exceptionInterpret.getExceptionMessageByType(ExceptionTypes.SPELLCOOLDOWN);
			throw new CooldownException(exceptionMessage);
		}

	}

}
