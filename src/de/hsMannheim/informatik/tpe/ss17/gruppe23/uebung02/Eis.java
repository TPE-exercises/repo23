package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of an ice cream cup.
 */
public class Eis {

	private String name;		// Bezeichnung des Eises 
	private double preis;		// Preis des Eises
	private String behaeltnis;	// Waffel/Becher/Teller/Schuessel/Glas/etc.
	private String art;			// Baellchen/Bälle/Spaghettis/Klekse/etc.
	private String[] sorten;	// Vanille/Schokolade/Straciatella/Zitrone/etc.
	private String[] extras;	// Sahne/Schokostraeusel/Keks/Sosse/etc.
	
	/**
	 * Creates a new ice cream of a given type.
	 * @param typ Type (name) of the ice cream.
	 */
	public Eis(String typ) {
		name = typ;
		
		// Eisbecher erstellen
		if(typ.equals("Spaghettieis")) {
			preis = 5.00;
			behaeltnis = "Becher";
			art = "Spaghettis";
			sorten = new String[] {"Vanille"};
			extras = new String[] {"Sahne", "Erdbeersoße", "Kokosflocken"};
		}
		else if(typ.equals("Schokoteller")) {
			preis = 4.00;
			behaeltnis = "Teller";
			art = "Baelle";
			sorten = new String[] {"Schokolade", "WeisseSchokolade"};
			extras = new String[] {"Sahne", "Schokososse", "Keks"};
		}
		//...
	}
	
	/**
	 * Prepares the vessel.
	 */
	public void vorbereiten() {
		println(behaeltnis + " nehmen.");
	}
	
	/**
	 * Fills the vessel with the specified sorts of ice cream.
	 */
	public void fuellen() {
		print(behaeltnis + " mit " + art + " von ");
		for(int i = 0; i < sorten.length; i++) {
			if(i > 0) {
				print (", "); 
			}
			print(sorten[i]);
		}
		print (" fuellen.\n");
	}
	
	/**
	 * Decorates the ice cream with the specified extras.
	 */
	public void dekorieren() {
		for(int i = 0; i < extras.length; i++) {
			println("Mit " + extras[i] + " dekorieren.");
		}
	}
	
	/**
	 * Returns the current price of the ice cream.
	 * @return The price of the ice cream.
	 */
	public double getPreis() {
		return preis;
	}
	
}
