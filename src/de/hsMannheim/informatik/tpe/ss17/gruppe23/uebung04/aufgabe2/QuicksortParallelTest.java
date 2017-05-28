package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortParallelTest {

	QuicksortParallel qs;
	
	@Before
	public void setUp() throws Exception {
		qs = new QuicksortParallel();
	}

	@Test
	public void test1() {
		Comparable[] array = {new Integer(5), new Integer(9),
							  new Integer(2), new Integer(4),
							  new Integer(7), new Integer(5),
							  new Integer(3), new Integer(35)};
		
		Comparable[] sorted = {	new Integer(2), new Integer(3),
							  	new Integer(4), new Integer(5),
							  	new Integer(5), new Integer(7),
							  	new Integer(9), new Integer(35)};
		
		qs.sort(array);
		
		for(int i = 0; i < array.length; i++) {
			assertTrue(array[i].equals(sorted[i]));
		}

		assertEquals("Comparisons: ",  21, qs.getComparisons());
		assertEquals("Swaps: ",  4, qs.getSwaps());
		assertEquals("Recursive Calls: ",  5, qs.getRecursiveCalls());
		assertEquals("Threads: ",  10, qs.getThreads());
	}
	
	@Test
	public void test2() {
		Comparable[] array = {new Integer(5), new Integer(9),
							  new Integer(2), new Integer(4),
							  new Integer(7), new Integer(5),
							  new Integer(3), new Integer(35),
							  new Integer(0), new Integer(-4),
							  new Integer(8), new Integer(87),
							  new Integer(31), new Integer(24),
							  new Integer(47), new Integer(42),
							  new Integer(29), new Integer(-3),
							  new Integer(73), new Integer(62),
							  new Integer(55), new Integer(-69),
							  new Integer(77), new Integer(60),
							  new Integer(39), new Integer(-23),
							  new Integer(56), new Integer(4),
							  new Integer(11), new Integer(05),
							  new Integer(45), new Integer(32),
							  new Integer(99), new Integer(26),
							  new Integer(44), new Integer(-8),
							  new Integer(67), new Integer(24),
							  new Integer(38), new Integer(33),
							  new Integer(95), new Integer(91)};
		
		Comparable[] sorted =  {  new Integer(-69), new Integer(-23),
								  new Integer(-8), new Integer(-4),
								  new Integer(-3), new Integer(0),
								  new Integer(2), new Integer(3),
								  new Integer(4), new Integer(4),
								  new Integer(5), new Integer(5),
								  new Integer(5), new Integer(7),
								  new Integer(8), new Integer(9),
								  new Integer(11), new Integer(24),
								  new Integer(24), new Integer(26),
								  new Integer(29), new Integer(31),
								  new Integer(32), new Integer(33),
								  new Integer(35), new Integer(38),
								  new Integer(39), new Integer(42),
								  new Integer(44), new Integer(45),
								  new Integer(47), new Integer(55),
								  new Integer(56), new Integer(60),
								  new Integer(62), new Integer(67),
								  new Integer(73), new Integer(77),
								  new Integer(87), new Integer(91),
								  new Integer(95), new Integer(99)};
		
		qs.sort(array);
		
		for(int i = 0; i < array.length; i++) {
			assertTrue(array[i].equals(sorted[i]));
		}

		assertEquals("Comparisons: ",  217, qs.getComparisons());
		assertEquals("Swaps: ",  69, qs.getSwaps());
		assertEquals("Recursive Calls: ",  26, qs.getRecursiveCalls());
		assertEquals("Threads: ",  52, qs.getThreads());
	}

}
