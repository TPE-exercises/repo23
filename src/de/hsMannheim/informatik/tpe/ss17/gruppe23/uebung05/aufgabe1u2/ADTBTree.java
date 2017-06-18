package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung05.aufgabe1u2;

public interface ADTBTree extends java.util.Iterator, Iterable {
	/**
	 * Inserts the Integer object o in the B-Tree
	 * @param o Integer object
	 * @return boolean if the insertion was successful.
	 */
	public boolean insert(Comparable o);
	
	/**
	 * Inserts the Elements written in an external file into the B-Tree
	 * @param filename Name of the external file.
	 * @return boolean if the insertion was successful.
	 */
	public boolean insert(String filename);
	
	/**
	 * Deletes a specific element from the B-Tree.
	 * @param element Element to delete.
	 */
	public void delete(Comparable element);
	
	/**
	 * Tests whether or not the Integer object o is in the B-Tree.  
	 * @param o Integer object
	 * @return boolean whether or not the Integer object o is in the B-Tree
	 */
	public boolean contains(Comparable o);
	
	/**
	 * Returns the number of the elements in the B-Tree.
	 * @return the number of the elements.
	 */
	public int size();
	
	/**
	 * Returns the height of the B-Tree
	 * @return the height.
	 */
	public int height();
	
	/**
	 * Returns the largest element of the B-Tree.
	 * @return the largest element.
	 */
	public Comparable getMax();
	
	/**
	 * Returns the smallest element of the B-Tree.
	 * @return the smallest element.
	 */
	public Comparable getMin();
	
	/**
	 * Returns true if the B-Tree is empty.
	 * @return the condition of the B-Tree. 
	 */
	public boolean isEmpty();
	
	/**
	 * Inserts all elements from the otherTree in the current B-Tree.
	 * @param otherTree B-Tree of which the elements should be inserted.
	 */
	public void addAll(BTree otherTree);
	
	/**
	 * Prints the B-Tree inorder.
	 */
	public void printInorder();
	
	/**
	 * Prints the B-Tree postorder.
	 */
	public void printPostorder();
	
	/**
	 * Prints the B-Tree preorder.
	 */
	public void printPreorder();
	
	/**
	 * Prints the B-Tree levelorder.
	 */
	public void printLevelorder();
	
	/**
	 * Creates a deep copy of the currenet B-Tree.
	 * @return Returns the deep copy.
	 */
	public BTree clone();
	
}
