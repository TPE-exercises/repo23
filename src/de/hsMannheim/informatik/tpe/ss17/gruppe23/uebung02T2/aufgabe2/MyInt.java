package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public class MyInt implements Comparable {
	private int value;
	
	public MyInt(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o == null) {
			throw new GDIException("Comparing object is null pointer.");
		}
		if(!(o instanceof MyInt)) {
			throw new GDIException("Comparing object is of an invalid type.");
		}
		
		MyInt other = (MyInt)o;
		if(this.value < other.getValue()) {
			return -1;
		}
		else if (this.value > other.getValue()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
