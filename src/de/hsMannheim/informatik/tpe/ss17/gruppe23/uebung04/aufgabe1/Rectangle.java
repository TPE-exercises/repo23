package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 * 
 * Implements the geometric figure rectangle and the possibility to 
 * calculate its area. 
 * This class shows the problem of using diverse threads which 
 * changing the fields of the rectangle at the same time.	
 */
public class Rectangle {
	private int baseline = 1;
	private int height = 1;
	
	Rectangle(int baseline, int height){
		this.baseline = baseline;
		this.height = height;
	}
	Rectangle(int baseline){
		this(baseline, 1);
	}
	Rectangle(){
		this(1, 1);
	}
	
	public int getBaseLine(){
		return this.baseline;
	}
	public void setBaseLine(int newBaseline){
		this.baseline = newBaseline;
	}
	public int getHeight(){
		return this.height;
	}
	public void setHeight(int newHeight){
		this.height = newHeight;
	}
	
	/**
	 * Returns the area of the rectangle.
	 * @return baseline * height
	 */
	public int getArea(){
		return baseline * height;
	}
}
