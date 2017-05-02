package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe1;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of an ice cream cup.
 * 
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 * 
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
	public Eis(String typ, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		this.name = typ;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = copyArray(sorten);
		this.extras = copyArray(extras);
	}
	
	private String[] copyArray(String[] array) {
		if(array == null) {
			return null;
		}
		
		String[] copy = new String[array.length];
		for(int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		return copy;
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
		print (" füllen.\n");
	}
	
	/**
	 * Decorates the ice cream with the specified extras.
	 */
	public void dekorieren() {
		print("Das Eis mit");
		if(extras.length == 0) {
			print(" nichts");
		}
		
		for(int i = 0; i < extras.length; i++) {
			if(i > 0) {
				print(",");
			}
			print(" " + extras[i]);
		}
		println(" dekorieren.");
	}
	
	/**
	 * Returns the current price of the ice cream.
	 * @return The price of the ice cream.
	 */
	public double getPreis() {
		return preis;
	}
	
}
