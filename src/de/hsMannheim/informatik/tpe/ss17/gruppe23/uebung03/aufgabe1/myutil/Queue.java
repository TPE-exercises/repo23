package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe1.myutil;

public interface Queue extends Cloneable{
	/**
	 * Inserts a new Element in the queue, containing the passed value.
	 * @param value to insert
	 */
	public void enter(Object value);
	
	/**
	 * Removes the first inserted element from the queue (FIFO).
	 * @return value of the removed element
	 */
	public Object leave();
	
	/**
	 * Returns the first element in the queue, which is removed at first.
	 * @return value of the first element.
	 */
	public Object front();
	
	/**
	 * Returns if the queue is empty (no elements) or not.
	 * @return true = no elements, false = elements in list
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in the queue.
	 * @return number of elements.
	 */
	public int size();
	
	/**
	 * Creates a flat copy of the queue, only cloning the queue object, not the
	 * actual Nodes.
	 * @return a flat copy
	 */
	public Queue clone();
//	
//	/**
//	 * Creates a deep copy of the queue, cloning the queue object with all content.
//	 * @return a deep copy
//	 */
//	public Queue cloneDeep();
	
	/**
	 * Creates a string with all node values.
	 * @return String with queue content.
	 */
	public String toString();
}
