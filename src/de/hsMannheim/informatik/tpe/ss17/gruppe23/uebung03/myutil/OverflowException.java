package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public class OverflowException extends Exception {
	
	private Object insertionObject;

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
