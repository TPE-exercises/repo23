package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe2;

import gdi.MakeItSimple.GDIException;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public class MyString implements Comparable{
	private String value;
	
	public MyString(String value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}

	@Override
	public int compareTo(Object o) {
		if(o == null) {
			throw new GDIException("Comparing object is null pointer.");
		}
		if(!(o instanceof MyString)) {
			throw new GDIException("Comparing object is of an invalid type.");
		}
		
		return value.compareTo(((MyString)o).getValue());
	}
}
