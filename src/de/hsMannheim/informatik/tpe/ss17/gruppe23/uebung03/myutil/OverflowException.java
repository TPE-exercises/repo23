package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class OverflowException extends Exception {
	
	private Object insertionObject; // The element that should be inserted when the overflowException occurs.

	public OverflowException(Object object) {
		super();
		this.insertionObject = object;
	}
	
	public OverflowException(String message, Object object) {
		super(message);
		this.insertionObject = object;
	}
	
	public Object getInsertionObject() {
		return insertionObject;
	}
}
