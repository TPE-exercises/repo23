package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe1;

public class CatchOrThrow {

	/*
	 * Aufgabe 1 a):
	 * 
	 * TODO a)
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
