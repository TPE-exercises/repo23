package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Beispiel für eine Race Condition Situation:
 * Das Programm verhält sich in Anwesenheit mehrerer Threads nicht mehr (unbedingt) korrekt.
 * Dabei hängt das Ergebnis des Programms von der zeitlichen Abarbeitung der Threads ab,
 * die jedoch nicht eindeutig gegeben ist. So kann das Ergebnis (ungewollt) variieren,
 * da die Variablen in einen inkonsistenten Zustand versetzt werden (können).
 * 
 * Hier sind die verschiedenen Threads nicht synchronisiert, d.h. die Reihenfolge der Zugriffe
 * auf das Objekt kann variieren.
 */

public class RaceCondition extends Thread {
	
	private Value2 value;
	private int newValue;
	
	public RaceCondition(Value2 value, int newValue) {
		this.value = value;
		this.newValue = newValue;
	}
	
	public void run() {
		value.setValue(newValue);
	}

	public static void main(String[] args) {
		Value2 value = new Value2(0);

		// Erzeuge 9 Threads, die nicht synchronisiert auf ein Objekt zugreifen.
		Thread t1 = new RaceCondition(value, 1); t1.start();
		Thread t2 = new RaceCondition(value, 2); t2.start();
		Thread t3 = new RaceCondition(value, 3); t3.start();
		Thread t4 = new RaceCondition(value, 4); t4.start();
		Thread t5 = new RaceCondition(value, 5); t5.start();
		Thread t6 = new RaceCondition(value, 6); t6.start();
		Thread t7 = new RaceCondition(value, 7); t7.start();
		Thread t8 = new RaceCondition(value, 8); t8.start();
		Thread t9 = new RaceCondition(value, 9); t9.start();

		// Warte bis alle Threads beendet sind.
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
			t9.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Gib den Wert aus, der am Ende im Objekt gespeichert ist (hier treten Abweichungen auf).
		System.out.println("Value after program: " + value.getValue());
	}
}

/**
 * This class contains an implementation of a single int value with getter and setter methods.
 */
class Value2 {
	private int value;

	public Value2(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
