package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * This class contains a basic implementation of a user interface for the ice cream shops. It is possible to test the functionality.
 */
public class EisdieleMain {
	
	private static String[] names = {"Mannheim", "Köln", "Berlin"};

	/**
	 * Creates a basic menu to access the ice cream shops and test the functionality.
	 */
	public static void main(String[] args) {
		Eisdiele[] eisdielen = new Eisdiele[names.length];
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals("Mannheim")) {
				eisdielen[i] = new MannheimerEisdiele();
			}
			else if(names[i].equals("Köln")) {
				eisdielen[i] = new KoelnerEisdiele();
			}
			else if(names[i].equals("Berlin")) {
				eisdielen[i] = new BerlinerEisdiele();
			}
			else {
				throw new GDIException("Unbekannte Stadt.");
			}
		}
		
		while(true) {
			println("Wo möchten Sie ein Eis bestellen?");
			for(int i = 0; i < names.length; i++) {
				if(i > 0) {
					print(", ");
				}
				print(i + " = " + names[i]);
			}
			println();
			int nr = readInt();
			readLine();
			if(nr < 0 || nr > 2) {
				println("Ungültige Eingabe!");
				continue;
			}
			
			println("Welches Eis möchten Sie bestellen?");
			for(int j = 0; j < names.length; j++) {
				print(names[j] + ": ");
				for(int i = 0; i < eisdielen[j].getEissorten().length; i++) {
					if(i > 0) {
						print(", ");
					}
					print(eisdielen[j].getEissorten()[i]);
				}
				println();
			}
			
			String choice = readLine();
			eisdielen[nr].bestellen(choice);
			
			print("\n\n\n");
			
		}
	}

}
