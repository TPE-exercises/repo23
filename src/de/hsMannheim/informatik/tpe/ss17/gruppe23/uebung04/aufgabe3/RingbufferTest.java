package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class RingbufferTest {

	Ringbuffer rb;
	
	@Before
	public void setUp() throws Exception {
		rb = new Ringbuffer(5);
	}
	
	@Test (expected = OverflowException.class)
	public void standardSizeOverflow() throws Exception {
		rb = new Ringbuffer();
		for(int i = 0; i < 5; i++) {
			rb.put(new Integer(i + 1));
		}
		
		// Invalid operation:
		rb.put(new Integer(9));
	}
	
	@Test
	public void standardSize() throws Exception {
		rb = new Ringbuffer();
		for(int i = 0; i < 5; i++) {
			rb.put(new Integer(i + 1));
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void negativeSize() throws Exception {
		rb = new Ringbuffer(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void zeroSize() throws Exception {
		rb = new Ringbuffer(0);
	}

	@Test
	public void isEmptyTrue() {
		assertTrue(rb.isEmpty());
	}

	@Test
	public void isEmptyFalse() throws Exception {
		rb.put(new Integer(0));
		assertFalse(rb.isEmpty());
	}
	
	@Test
	public void isEmptyPutGet() throws Exception {
		rb.put(new Integer(0));
		rb.get();
		assertTrue(rb.isEmpty());
	}
	
	@Test (expected = UnderflowException.class)
	public void getEmptyRinbBuffer() throws Exception {
		rb.get();
	}
	
	@Test (expected = OverflowException.class)
	public void putFullRinbBuffer() throws Exception {
		for(int i = 0; i < 6; i++) {
			rb.put(new Integer(i));
		}
	}
	
	@Test
	public void enterOneElement() throws Exception {
		rb.put(new Integer(0));
		assertTrue(rb.get().equals(new Integer(0)));
	}
	
	@Test
	public void enterOneElementMultiple() throws Exception {
		for(int i = 0; i < 20; i++) {
			rb.put(new Integer(i));
			assertTrue(rb.get().equals(new Integer(i)));
		}
	}
	
	@Test
	public void enterFiveElements() throws Exception {
		for(int i = 0; i < 5; i++) {
			rb.put(new Integer(i + 1));
		}
		
		for(int i = 0; i < 5; i++) {
			assertTrue(rb.get().equals(new Integer(i + 1)));
		}
	}
	
	@Test
	public void enterFiveElementsMultiple() throws Exception {
		for(int j = 0; j < 20; j++) {
			for(int i = 0; i < 5; i++) {
				rb.put(new Integer(i + 1));
			}
			
			for(int i = 0; i < 5; i++) {
				assertTrue(rb.get().equals(new Integer(i + 1)));
			}
		}
	}
	
	@Test
	public void enterAfterUnderflow() throws Exception {
		try {
			rb.get();
		} catch (UnderflowException e) {
			// Underflow Exception expected
		}
		
		for(int i = 0; i < 5; i++) {
			rb.put(new Integer(i + 1));
		}
		
		for(int i = 0; i < 5; i++) {
			assertTrue(rb.get().equals(new Integer(i + 1)));
		}
	}
	
	@Test
	public void getAfterOverflow() throws Exception {
		for(int i = 0; i < 5; i++) {
			rb.put(new Integer(i + 1));
		}
		
		// Invalid operation:
		try {
			rb.put(new Integer(9));
		} catch (OverflowException e) {
			// OverflowExpected
		}
		
		for(int i = 0; i < 5; i++) {
			assertTrue(rb.get().equals(new Integer(i + 1)));
		}
	}

}
