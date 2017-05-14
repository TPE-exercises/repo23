package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe1;

public class CatchOrThrow {

	/*
	 * Aufgabe 1 a):
	 * 
	 * Wenn eine Exception geworfen wird oder eine Methode aufgerufen wird, die eine Exception werfen kann,
	 * dann muss der Code entweder in einem geschützten Block (try/catch) ausgeführt werden oder die möglichen
	 * auftretenden Exceptions müssen durch ein "throw ExceptionType" in der Methodensignatur in der Aufrufkette
	 * "weitergereicht" werden. Da der Compiler das überprüft und eins davon vorhanden sein muss, nennt man das
	 * auch catch or throw Regel. Das gilt jedoch nicht für Runtime Exceptions, da diese meistens durch den
	 * Code verhindert werden sollten und nicht abgefangen werden sollten.
	 * 
	 * Im folgenden befindet sich ein einfaches Beispiel, das die beiden Methoden veranschaulicht.
	 */
	
	public static void method1() throws Exception {
		throw new Exception("Something went wrong in method1().");
	}
	
	public static void method2() {
		try {
			throw new Exception("Something went wrong in method2().");
		}
		catch(Exception e) {
			System.out.println("Catched in method2: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			method1();
		}
		catch(Exception e) {
			System.out.println("Catched in main: " + e.getMessage());
		}
		
		method2();
	}
}
