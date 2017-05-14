package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public interface Stack {
	
	public void push(Object element) throws OverflowException;
	
	public Object pop() throws UnderflowException;
	
	public Object top() throws UnderflowException;
	
	public Stack empty();
	
	public Stack empty(int puffer);
	
	public boolean isEmpty();
	
	public int size();
	
}
