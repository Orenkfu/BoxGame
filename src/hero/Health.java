package hero;

public class Health {
	private int currentHealth;
	private static final int MAX_HEALTH = 100;

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int health) {
		currentHealth = health;
	}

	public static int getMaxHealth() {
		return MAX_HEALTH;
	}

	public Health() {
		super();
		currentHealth = MAX_HEALTH;
	}
}
