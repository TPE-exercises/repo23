package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

import java.util.Random;

/**
 * This class contains a producer thread that writes random values to a 
 * ring buffer. If the ring buffer is full, the producer waits until there
 * is another free space in the ring buffer.
 *
 */
public class Producer extends Thread {
	
	private Ringbuffer rb;
	private int sleepTime;
	private int seed;
	
	/**
	 * Creates a new producer writing random values in a specific ring buffer.
	 * @param rb The ring buffer to write to.
	 * @param sleepTime The time to wait between writings to create
	 * 			different speeds.
	 * @param seed A seed to create the random values.
	 */
	public Producer(Ringbuffer rb, int sleepTime, int seed) {
		this.rb = rb;
		this.sleepTime = sleepTime;
		this.seed = seed;
	}
	
	/**
	 * This method is run in parallel and writes random values to a ring buffer.
	 */
	public void run() {
		Random random = new Random(seed);
		boolean valueSaved = false;
		int value = random.nextInt();
		while(true) {
			if(isInterrupted()) {
				// End thread properly
				return;
			}
			
			if(valueSaved) {
				value = random.nextInt();
				valueSaved = false;
			}
			
			synchronized (rb) {
				try {
					rb.put(value / 1000000);
					valueSaved = true;
					
					rb.notifyAll();
				}
				catch(OverflowException e) {
					try {
						// Wait for new values to write.
						rb.wait();
					} catch (InterruptedException e1) {
						interrupt();
					}
				}
				
				if(valueSaved) {
					System.out.println("Producer " + this.getName() + " inserted value: " + (value / 1000000));
				}
			}
			
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				interrupt();
			}
		}
	}

}
