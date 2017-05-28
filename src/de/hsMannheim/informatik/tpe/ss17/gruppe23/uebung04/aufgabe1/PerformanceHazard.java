package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Beispiel für einen Performance Hazard:
 * Wenn ein Programm zwar mit mehreren Threads korrekt funktioniert, jedoch die
 * Performance sehr schlecht ist, spricht man von Performance Hazards.
 * 
 * Hier wird die gleiche Aufgabe einmal sequentiell und einmal parallel ausgeführt.
 * Zu sehen ist, dass die parallele Ausführung um einiges länger dauert, obwohl
 * sie vermeintlich durch parallelisierung beschleunigt wurde.
 */

/**
 * Führt einen einfachen Schritt aus (erhöht value um eins).
 */
public class PerformanceHazard extends Thread {
	
	Value value;
	
	public PerformanceHazard(Value v) {
		this.value = v;
	}

	public void run() {
		synchronized (value) {
			value.setValue(value.getValue() + 1);
		}
	}
	
	
	/**
	 * Führt einmal die Aufgabe sequentiell und einmal parallel aus und gibt die gebrauchte Zeit
	 * zum Vergleichen auf der Console aus.
	 */
	public static void main(String[] args) {
		System.out.println("Perform Task sequential:");
		
		long timeSequential = System.currentTimeMillis();
		Value value1 = new Value(0);
		for(int i = 0; i < 1000; i++) {
			value1.setValue(value1.getValue() + 1);
		}
		timeSequential = System.currentTimeMillis() - timeSequential;
		System.out.println("Zeit: " + timeSequential + "ms");
		System.out.println();
		
		System.out.println("Perform Task parallel:");
		
		long timeParallel = System.currentTimeMillis();
		Value value2 = new Value(0);
		for(int i = 0; i < 1000; i++) {
			new PerformanceHazard(value2).start();
		}
		timeParallel = System.currentTimeMillis() - timeParallel;
		System.out.println("Zeit: " + timeParallel + "ms");
		System.out.println();
		
	}
	
}

/**
 * Die Klasse enthält eine Darstellung eines int Wertes, auf den über
 * getter und setter zugegriffen werden kann.
 */
class Value {
	
	private int value;
	
	public Value(int value) {
		this.value = value;
	}
	
	public void setValue(int newValue) {
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}
	
}
