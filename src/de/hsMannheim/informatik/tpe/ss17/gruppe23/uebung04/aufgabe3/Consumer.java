package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

/**
 * This class contains a consumer thread that reads Integer values from a 
 * ring buffer and writes it to the console. If there is no element in the
 * ring buffer, the thread waits for new values.
 * 
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class Consumer extends Thread {
	
	private Ringbuffer rb;
	private int sleepTime;

	/**
	 * Creates a new consumer that reads from a specific buffer.
	 * @param buffer The buffer to read from.
	 * @param sleepTime The time to wait between readings to create
	 * 			different speed.
	 */
	public Consumer(Ringbuffer buffer, int sleepTime) {
		this.rb = buffer;
		this.sleepTime = sleepTime;
	}
	
	/**
	 * This method is run in parallel and writes values from a ring buffer to
	 * the console.
	 */
	public void run() {
		Object value = null;
		while(true) {
			if(isInterrupted()) {
				// End thread properly
				return;
			}
			
			synchronized (rb) {
				try {
					value = rb.get();
					
					System.out.print("Consumer " + this.getName() + " extracted value: ");
					System.out.println(((Integer)value).toString());
					
					rb.notifyAll();
				}
				catch(UnderflowException e) {
					try {
						// Wait for new values to read
						rb.wait();
					} catch (InterruptedException e1) {
						interrupt();
					}
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
