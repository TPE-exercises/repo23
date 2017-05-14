package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

/**
 * This interface specifies a queue that has a specific size and expands one time if it is full.
 * 
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public interface Queue {

	public static final int STANDARD_PUFFER = 5; // Specifies the standard buffer.
	
	/**
	 * Inserts an element at the end of the queue.
	 * @param element Element to insert.
	 * @throws OverflowException if the queue is already full.
	 */
	public void enter(Object element) throws OverflowException;
	
	/**
	 * Removes the first element from the queue.
	 * @return The first element of the queue, that was removed.
	 * @throws UnderflowException if the queue is empty and no element could be removed.
	 */
	public Object leave() throws UnderflowException;
	
	/**
	 * Returns the first element in the queue.
	 * @return The first element in the queue.
	 * @throws UnderflowException if the queue is empty and has no elements.
	 */
	public Object front() throws UnderflowException;
	
	/**
	 * Creates a new empty queue with a length of the standard buffer.
	 * @return New empty queue.
	 */
	public Queue empty();
	
	/**
	 * Creates a new empty queue with a specified length.
	 * @param bufferSize length of the queue.
	 * @return New empty queue.
	 */
	public Queue empty(int bufferSize);
	
	/**
	 * Returns whether the queue is empty or not.
	 * @return true = empty, false = not empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements stored in the queue.
	 * @return number of elements.
	 */
	public int size();
}
