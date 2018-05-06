package exceptions;

public class SpellOnCooldownException extends MyGameException {

	public SpellOnCooldownException(String message) {
		super(message);

	}

	public SpellOnCooldownException() {
		String message = "this spell is on cooldown.";
	}

}
