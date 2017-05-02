package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * This class contains a basic implementation of a user interface for the ice cream shops. It is possible to test the functionality.
 */
public class EisdieleMain {
	
	
	/*
	 * Aufgabe 2:
	 * Was muss hier geschehen? Brauchen Sie zusätzliche Klassen und Methoden? Wenn Ja - welche? Was muss in
	 * Ihrer main() passieren um die jeweiligen lokalen Eisdielen anzusprechen? Müssen Sie bestehende Methoden
	 * ändern oder verlagern? Notieren Sie die Vorteile dieser Lösung in Aufgabe 2 gegenüber der Lösung von
	 * Aufgabe 1.
	 * 
	 * Nur die Methoden zur Interaktion mit dem Kunden müssen geändert werden, die Basis-Funktionalität wird
	 * in der abstrakten Eisdiele hergestellt. Um aus den Unterklassen den Zugriff auf die Attribute der abstrakten
	 * Klasse zu ermöglichen wurden getter-Methoden ergänzt. Die zusätzlichen Klassen Mannheimer-, Kölner- und
	 * BerlinerEisdiele wurden angelegt. In der main() kann ganz normal auf die Elemente,
	 * die in einer Variable vom statischen Typ Eisdiele gespeichert werden, zugegriffen werden. Um eine neue
	 * Eisdiele anzulegen wird einfach ein Objekt einer konkreten lokalen Implementierung einer Eisdiele
	 * gespeichert, wobei der Zugriff wie in der abstrakten Klasse definiert, einheitlich ist.
	 * Der Vorteil dieser Lösung ist die einfache Erweiterbarkeit und die Vermeidung von Redundanz in wichtigen
	 * Programmfunktionen, die gesammelt in den abstrakten Klassen stehen.
	 */
	
	
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
			if(nr < 0 || nr > (names.length - 1)) {
				println("Ungültige Eingabe!");
				continue;
			}
			
			println("Welches Eis möchten Sie bestellen?");
			for(int i = 0; i < eisdielen[nr].getEissorten().length; i++){
				if(i > 0) {
					print(", ");
				}
				print(eisdielen[nr].getEissorten()[i]);
			}
			
			String choice = readLine();
			eisdielen[nr].bestellen(choice);
			
			print("\n\n\n");
			
		}
	}
	

}
