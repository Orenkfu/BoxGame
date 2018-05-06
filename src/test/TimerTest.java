package test;

import system.Timer;

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer(1000);
		timer.start();
		while (!timer.isExpired()) {

		}
		System.out.println("timer expired");
	}

}
