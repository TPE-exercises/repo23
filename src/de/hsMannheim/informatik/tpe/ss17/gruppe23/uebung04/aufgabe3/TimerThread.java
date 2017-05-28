package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

/**
 * This class contains a timer thread that waits for a specified amount
 * of time.
 *
 */
public class TimerThread extends Thread {

	private int time;
	
	/**
	 * Creates a new timer thread with a specific time to wait.
	 * Once a timer is created the timer starts.
	 * @param time
	 */
	public TimerThread(int time) {
		this.time = time * 60 * 1000;
		start();
	}
	
	/**
	 * Waits for the given amount of time, can be interrupted from another thread.
	 */
	public void run() {
		try {
			sleep(time);
		} catch (InterruptedException e) {
			return;
		}
	}
}
