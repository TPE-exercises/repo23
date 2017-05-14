package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public interface Queue {

	public static final int STANDART_PUFFER = 5;
	
	public void enter(Object element) throws OverflowException;
	
	public Object leave() throws UnderflowException;
	
	public Object front() throws UnderflowException;
	
	public Queue empty();
	
	public Queue empty(int bufferSize);
	
	public boolean isEmpty();
	
	public int size();
}
