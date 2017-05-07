package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe1.myutil;

public interface Stack extends Cloneable{
	
	public void push(Object o);
	
	public Object push();
	
	public Object getFirst();
	
	public int size();
	
	public boolean isEmpty();
	
	public Stack clone();
	
	public String toString();
}
