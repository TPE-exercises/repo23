package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProducerTest {
	
	public static final int seed = 0;
	public static final int[] values = {-1155, -723, 1033, -1690, -1557};
	// Values: 
	Ringbuffer rb;
	Producer producer, producer2;

	@Before
	public void setUp() throws Exception {
		rb = new Ringbuffer(5);
	}

	@Test
	public void writingInEmptyRingBuffer() throws Exception {
		producer = new Producer(rb, 0, seed);
		
		producer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		for(int i = 0; i < 5; i++) {
			assertTrue("Value " + values[i] + " properly inserted.", rb.get().equals(new Integer(values[i])));
		}
	}
	
	@Test
	public void writingInFullRingBuffer() throws Exception {
		rb.put(new Integer(1));
		rb.put(new Integer(2));
		rb.put(new Integer(3));
		rb.put(new Integer(4));
		rb.put(new Integer(5));
		producer = new Producer(rb, 0, seed);
		
		producer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		for(int i = 0; i < 5; i++) {
			assertTrue("Value changed to invalid value.", rb.get().equals(new Integer(i + 1)));
		}
	}
	
	@Test
	public void writingInPartlyFilledRingBuffer() throws Exception {
		rb.put(new Integer(1));
		rb.put(new Integer(2));
		rb.put(new Integer(3));
		producer = new Producer(rb, 0, seed);
		
		producer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new Exception("An error occured while executing the program.");
		}
		
		for(int i = 0; i < 3; i++) {
			assertTrue("Value changed to invalid value.", rb.get().equals(new Integer(i + 1)));
		}
		assertTrue("Value -1155 properly inserted.", rb.get().equals(new Integer(-1155)));
		assertTrue("Value -723 properly inserted.", rb.get().equals(new Integer(-723)));
	}
	
}
