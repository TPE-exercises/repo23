package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class ConsumerTest {

	Ringbuffer rb;
	Consumer consumer, consumer2;
	
	@Before
	public void setUp() throws Exception {
		rb = new Ringbuffer(5);
	}

	@Test
	public void readFromEmptyRingBuffer() throws Exception {
		consumer = new Consumer(rb, 0);
		
		consumer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		consumer.interrupt();
		
		assertTrue("Ring buffer unchanged.", rb.isEmpty());
	}
	
	@Test
	public void readFromFullRingBuffer() throws Exception {
		rb.put(new Integer(1));
		rb.put(new Integer(2));
		rb.put(new Integer(3));
		rb.put(new Integer(4));
		rb.put(new Integer(5));
		consumer = new Consumer(rb, 0);
		
		consumer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		consumer.interrupt();
		
		assertTrue("Ring buffer unchanged.", rb.isEmpty());
	}
	
	@Test
	public void twoConsumerReadingFromEmptyRingBuffer() throws Exception {
		consumer = new Consumer(rb, 0);
		consumer2 = new Consumer(rb, 0);
		
		consumer.start();
		consumer2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		consumer.interrupt();
		consumer2.interrupt();
		
		assertTrue("Ring buffer unchanged.", rb.isEmpty());
	}
	
	@Test
	public void twoConsumersReadFromFullRingBuffer() throws Exception {
		rb.put(new Integer(1));
		rb.put(new Integer(2));
		rb.put(new Integer(3));
		rb.put(new Integer(4));
		rb.put(new Integer(5));
		
		consumer = new Consumer(rb, 0);
		consumer2 = new Consumer(rb, 0);
		
		consumer.start();
		consumer2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		consumer.interrupt();
		consumer2.interrupt();
		
		assertTrue("Ring buffer unchanged.", rb.isEmpty());
	}

}
