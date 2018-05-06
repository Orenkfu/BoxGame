package exceptions;

public class ExceptionTypeInterpreter {

	public String getExceptionMessageByType(ExceptionTypes type) {
		if (type.equals(ExceptionTypes.SPELLCOOLDOWN)) {
			return "Spell is on cooldown.";
		}

		if (type.equals(ExceptionTypes.ATTACKCOOLDOWN)) {
			return "Attack is on cooldown.";
		}
		return "Unknown exception type.";

	}

}
