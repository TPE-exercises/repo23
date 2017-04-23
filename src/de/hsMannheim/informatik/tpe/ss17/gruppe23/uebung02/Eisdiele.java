package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of a large ice cream shop only selling ice cream cups.
 */
public class Eisdiele {

	
	public Eisdiele() {
		// Default constructor
	}
	
	/**
	 * Executes the process of buying a cup of ice cream.
	 * @param typ Sort of the ordered ice cream.
	 */
	public void bestellen(String typ) {
		begruessen(typ);
		
		boolean eisVerfuegbar = true;
		if(!eisVerfuegbar) {
			entschuldigen();
		}
		else {
			// Eis erstellen
			Eis eis = new Eis(typ);
			
			kassieren(eis.getPreis());
		}
		
		verbschieden();
	}
	
	/**
	 * Welcomes the customer in the ice cream shop.
	 * @param name Name of the ice cream the customer ordered.
	 */
	public void begruessen(String name) {
		println("Guten Tag. Sie haben gerade ein " + name + " bestellt.");
	}
	
	/**
	 * Takes the money of the customer.
	 * @param preis Price to pay for the ordered ice cream.
	 */
	public void kassieren(double preis) {
		println("Das Eis kostet " + preis + "€.");
		println("Vielen Dank fuer ihren Einkauf.");
	}
	
	/**
	 * Says goodbye to the customer.
	 */
	public void verbschieden() {
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}
	
	/**
	 * Says sorry to the customer for not having the desired sort of ice cream.
	 */
	public void entschuldigen() {
		println("Das gewuenschte Eis ist leider nicht verfuegbar. Versuchen Sie es doch mit einem anderen.");
	}
	
}
