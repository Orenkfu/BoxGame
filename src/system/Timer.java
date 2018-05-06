package system;

public class Timer {

	long start = 0;
	long delay;

	public Timer(long delay) {
		this.delay = delay;
	}

	public void start() {
		this.start = System.currentTimeMillis();
	}

	public boolean isExpired() {

		if (System.currentTimeMillis() - this.start > this.delay)
			return true;
		else
			return false;
	}

}
