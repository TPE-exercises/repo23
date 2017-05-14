package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

/**
 * This interface specifies a queue that gas a specific size and expands one time if it is full.
 * 
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public interface Stack {
	
	public static final int STANDARD_PUFFER = 5; // Specifies the standard buffer.
	
	/**
	 * Pushes a new element to the top of the stack.
	 * @param element Element to insert.
	 * @throws OverflowException if the stack is already full.
	 */
	public void push(Object element) throws OverflowException;
	
	/**
	 * Removes the element on top of the stack.
	 * @return The previously top element.
	 * @throws UnderflowException if the stack is empty and has no elements.
	 */
	public Object pop() throws UnderflowException;
	
	/**
	 * Returns the element on top of the stack.
	 * @return the top element.
	 * @throws UnderflowException if the stack is empty and has no elements.
	 */
	public Object top() throws UnderflowException;
	
	/**
	 * Creates a new empty stack with a standard size.
	 * @return new empty stack.
	 */
	public Stack empty();
	
	/**
	 * Creates a new empty stack with a specified size.
	 * @param puffer size of the stack.
	 * @return new empty stack.
	 */
	public Stack empty(int puffer);
	
	/**
	 * Returns whether the stack is empty of not.
	 * @return true = empty, false = not empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements stored on the stack.
	 * @return number of elements.
	 */
	public int size();
	
}
