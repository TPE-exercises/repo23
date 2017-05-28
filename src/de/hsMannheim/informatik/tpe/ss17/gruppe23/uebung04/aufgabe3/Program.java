package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

public class Program {

	public static void main(String[] args) {
		// Create a new ring buffer
		Ringbuffer ringbuffer = new Ringbuffer();

		// Create three producer threads
		Producer p1 = new Producer(ringbuffer, 500, 0);
		Producer p2 = new Producer(ringbuffer, 500, 0);
		Producer p3 = new Producer(ringbuffer, 500, 0);

		// Create two consumer threads
		Consumer c1 = new Consumer(ringbuffer, 1000);
		Consumer c2 = new Consumer(ringbuffer, 1000);
		
		// Create and start a timer thread
		TimerThread t = new TimerThread(1);
		
		// Start the producer and consumer threads
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		
		try {
			// Wait for the timer thread to end after the specified amount of time.
			t.join();
		} catch (InterruptedException e) {
			System.out.println("An error occured.");
		}
		
		// Interrupt the producer and consumer threads
		p1.interrupt();
		p2.interrupt();
		p3.interrupt();
		c1.interrupt();
		c2.interrupt();
	}
}
