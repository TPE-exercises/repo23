package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe3;

/**
 * This class contains an implementation of a ring buffer using an array and a specific length.
 * 
 */
public class Ringbuffer {
	private static final int STANDARD_SIZE = 5;

	private Object elements[];	// Elements in the ring buffer
	private int start = 0, end = 0;
	
	/**
	 * Creates a new ring buffer with a standard size.
	 */
	public Ringbuffer() {
		this(STANDARD_SIZE);
	}
	
	/**
	 * Creates a new ring buffer with a specific size.
	 * @param size Length of the ring buffer.
	 */
	public Ringbuffer(int size) {
		if(size <= 0) {
			throw new IllegalArgumentException("Buffer size has to be positive.");
		}
		
		elements = new Object[size + 1];
	}
	
	/**
	 * Puts a new value in the ring buffer.
	 * @param element Element to insert.
	 * @throws OverflowException OverflowException if the ring buffer is already full.
	 */
	public void put(Object element) throws OverflowException {
		if((elements.length - start + end) % elements.length == elements.length - 1) {
			throw new OverflowException();
		}
		else {
			elements[end] = element;
			end = (end + 1) % elements.length;
		}
	}
	
	/**
	 * Returns the first element in the ring buffer.
	 * @return The first element.
	 * @throws UnderflowException UnderflowException if the ring buffer is empty.
	 */
	public Object get() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException();
		}
		else {
			Object value = elements[start];
			elements[start] = null;
			start = (start + 1) % elements.length;
			
			return value;
		}
	}
	
	/**
	 * Returns if the ring buffer is empty.
	 * @return true = empty (buffer contains no values)
	 * 		   false = not empty (buffer contains values)
	 */
	public boolean isEmpty() {
		return start == end;
	}
	
	/**
	 * Returns the number of stored elements in the ring buffer.
	 * @return size of the ring buffer.
	 */
	private int getSize() {
		return (elements.length + (end - start)) % elements.length;
	}
	
}
