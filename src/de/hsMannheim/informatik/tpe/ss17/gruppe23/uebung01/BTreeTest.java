package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung01;

import static gdi.MakeItSimple.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class BTreeTest {

	BTree tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new BTree(2);
	}
	
	@Test
	public void createBTreeTest() {
		assertTrue(tree.isEmpty());
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(tree.isEmpty());
		
		tree.insert(new Integer(123));
		assertFalse(tree.isEmpty());
	}

	@Test
	public void getMinTest() {
		tree.insert(new Integer(5));
		assertEquals(new Integer(5), tree.getMin());
		
		tree.insert(new Integer(6));
		assertEquals(new Integer(5), tree.getMin());
		
		tree.insert(new Integer(4));
		tree.insert(new Integer(8));
		tree.insert(new Integer(9));
		assertEquals(new Integer(4), tree.getMin());
		
		tree.insert(new Integer(-100));
		assertEquals(new Integer(-100), tree.getMin());
	}
	
	@Test(expected = GDIException.class)
	public void getMinEmptyTree() {
		tree.getMin();
	}
	
	@Test
	public void getMaxTest() {
		tree.insert(new Integer(5));
		assertEquals(new Integer(5), tree.getMax());
		
		tree.insert(new Integer(6));
		assertEquals(new Integer(6), tree.getMax());
		
		tree.insert(new Integer(4));
		tree.insert(new Integer(8));
		tree.insert(new Integer(9));
		assertEquals(new Integer(9), tree.getMax());
		
		tree.insert(new Integer(-100));
		assertEquals(new Integer(9), tree.getMax());
	}
	
	@Test(expected = GDIException.class)
	public void getMaxEmptyTree() {
		tree.getMax();
	}
	
	@Test
	public void containsElementTest() {
		assertFalse(tree.contains(null));
		assertFalse(tree.contains(new Integer(5)));
		assertFalse(tree.contains(new Integer(-5)));
		
		tree.insert(new Integer(3));
		tree.insert(new Integer(4));
		tree.insert(new Integer(5));
		tree.insert(new Integer(7));
		tree.insert(new Integer(6));
		tree.insert(new Integer(8));
		tree.insert(new Integer(0));
		tree.insert(new Integer(-9));
		tree.insert(new Integer(10));

		assertTrue(tree.contains(new Integer("6")));
		assertTrue(tree.contains(new Integer("-9")));
		assertTrue(tree.contains(new Integer("0")));

		assertFalse(tree.contains(new Integer("12")));
		assertFalse(tree.contains(new Integer("9")));
		assertFalse(tree.contains(new Integer("-8")));
		assertFalse(tree.contains(null));
	}

	@Test
	public void sizeTest() {
		assertEquals(0, tree.size());
		
		tree.insert(new Integer(3));
		assertEquals(1, tree.size());
		
		tree.insert(new Integer(4));
		assertEquals(2, tree.size());
		
		tree.insert(new Integer(5));
		assertEquals(3, tree.size());
		
		tree.insert(new Integer(7));
		assertEquals(4, tree.size());
		
		tree.insert(new Integer(6));
		assertEquals(5, tree.size());
		
		tree.insert(new Integer(8));
		assertEquals(6, tree.size());
		
		tree.insert(new Integer(0));
		assertEquals(7, tree.size());
		
		tree.insert(new Integer(-9));
		assertEquals(8, tree.size());
		
		tree.insert(new Integer(10));
		assertEquals(9, tree.size());
		
		
	}

	@Test
	public void heightTest() {
		assertEquals(0, tree.height());
		
		tree.insert(new Integer(3));
		assertEquals(1, tree.height());
		
		tree.insert(new Integer(4));
		assertEquals(1, tree.height());
		
		tree.insert(new Integer(-9));
		assertEquals(1, tree.height());
		
		tree.insert(new Integer(0));
		assertEquals(1, tree.height());
		
		tree.insert(new Integer(6));
		assertEquals(2, tree.height());

		tree.insert(new Integer(7));
		tree.insert(new Integer(8));
		tree.insert(new Integer(9));
		assertEquals(2, tree.height());
		
		for(int i = 10; i <= 18; i++) {
			tree.insert(new Integer(i));
		}
		assertEquals(3, tree.height());
	}
	
	@Test
	public void insertTest(){
		
		assertTrue(tree.insert(new Integer(3)));
		assertTrue(tree.insert(new Integer(4)));
		assertTrue(tree.insert(new Integer(-9)));
		assertTrue(tree.insert(new Integer(0)));

		assertFalse(tree.insert(new Integer(4)));
		assertFalse(tree.insert(new Integer(-9)));
		assertFalse(tree.insert(new Integer(0)));

		assertFalse(tree.insert((Object)null));
		
		assertTrue(tree.contains(new Integer("3")));
		assertTrue(tree.contains(new Integer("4")));
		assertTrue(tree.contains(new Integer("-9")));
		assertTrue(tree.contains(new Integer("0")));
		
		assertFalse(tree.contains(new Integer("-20")));
		assertFalse(tree.contains(new Integer("100")));

	}
	
	@Test
	public void valuesTest() {
		tree.insert(new Integer(3));
		tree.insert(new Integer(4));
		tree.insert(new Integer(-9));
		tree.insert(new Integer(0));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(8));
		tree.insert(new Integer(9));
		
		Object[] values = tree.values();
		Object[] reference = {3, 7, -9, 0, 4, 6, 8, 9};
		
		assertEquals(reference.length, values.length);
		
		for(int i = 0; i < reference.length && i < values.length; i++) {
			assertEquals(reference[i], values[i]);
		}
	}
	
	@Test
	public void addAllTest() {
		// Degree 3 tree in degree 2 tree
		BTree tree1 = new BTree(2), tree2 = new BTree(3);
		
		for(int i = -10; i < 10; i++) {
			tree2.insert(new Integer(i));
		}
		for(int i = 10; i <= 30; i++) {
			tree1.insert(new Integer(i));
		}
		
		tree1.addAll(tree2);
		
		for(int i = -10; i <= 30; i++) {
			assertTrue(tree1.contains(new Integer(i)));
		}
		assertFalse(tree1.contains(new Integer(-20)));
		assertFalse(tree1.contains(new Integer(31)));
		
		// Degree 2 tree in degree 3 tree
		tree1 = new BTree(2);
		tree2 = new BTree(3);

		for(int i = -10; i < 10; i++) {
			tree2.insert(new Integer(i));
		}
		for(int i = 10; i <= 30; i++) {
			tree1.insert(new Integer(i));
		}

		tree2.addAll(tree1);

		for(int i = -10; i <= 30; i++) {
			assertTrue(tree2.contains(new Integer(i)));
		}
		assertFalse(tree2.contains(new Integer(-20)));
		assertFalse(tree2.contains(new Integer(31)));
	}
	
	@Test
	public void cloneTest() {
		BTree clone;
		
		for(int i = -10; i <= 10; i++) {
			tree.insert(new Integer(i));
		}
		
		clone = tree.clone();
		
		//assertTrue(tree.equals(clone));
		
		assertEquals(tree.getOrder(), clone.getOrder());
		assertEquals(tree.height(), clone.height());
		assertEquals(tree.size(), clone.size());
		assertEquals(tree.getMax(), clone.getMax());
		assertEquals(tree.getMin(), clone.getMin());
		
		for(int i = -10; i <= 10; i++) {
			assertTrue(clone.contains(new Integer(i)));
		}
		assertFalse(clone.contains(new Integer(-20)));
		assertFalse(clone.contains(new Integer(12)));
	}
	
	@Test
	public void toStringTest() {
		assertEquals("", tree.toString());
		
		tree.insert(new Integer(3));
		assertEquals("[3] ", tree.toString());

		tree.insert(new Integer(4));
		tree.insert(new Integer(5));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		assertEquals("[5] [3 4] [6 7] ", tree.toString());
	}

}
